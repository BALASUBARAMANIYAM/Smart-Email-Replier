package com.example.email_writer.EmailService;

import com.example.email_writer.EmailController.EmailRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class Emailservice {

    private final WebClient webClient;

    @Value("${gemini.api.url}")
    String geminiApiUrl;

    @Value("${gemini.api.key}")
    String geminiApikey;

    public Emailservice(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public String generateEmailReply(EmailRequest emailRequest)
    {


        //Build the prompt
        String prompt = buildPrompt(emailRequest);

        //Craft the request(Making our request similar to the prompt)
        Map<String,Object> requestBody = Map.of(
                "contents",new Object[]{
                        Map.of("parts", new Object[]{
                            Map.of("text",prompt)
                })
                }
        );

        //Do and get Response

         String response = webClient.post()
                 .uri(geminiApiUrl + geminiApikey)
                 .header("Content-Type","application/json")
                 .bodyValue(requestBody)
                 .retrieve()
                 .bodyToMono(String.class)
                 .block();

        //Extract the response text and Return response

        return extractResponseContent(response);

    }

    private String extractResponseContent(String response) {
         try{
             ObjectMapper mapper = new ObjectMapper();
             //Objectmapper converts JSON to java object and vice versa
             JsonNode rootNode =mapper.readTree(response);
             //readTree converts JSON to tree like structure
             return rootNode.path("candidates")
                     .get(0)
                     .path("content")
                     .path("parts")
                     .get(0)
                     .path("text")
                     .asText();
         }catch (Exception e){
             return "Error Processing request: " + e.getMessage();
         }
    }

    private String buildPrompt(EmailRequest emailRequest) {
        StringBuilder prompt = new StringBuilder();
        prompt.append("Generate a professional email reply for the following email content.Please don't generate a subject line  ");
        if (emailRequest.getTone()!=null && !emailRequest.getTone().isEmpty()){
            prompt.append("Use a ").append(emailRequest.getTone()).append(" tone");
        }
        prompt.append("\nOriginal email: \n").append(emailRequest.getEmailContent());
        return prompt.toString();
    }


}
