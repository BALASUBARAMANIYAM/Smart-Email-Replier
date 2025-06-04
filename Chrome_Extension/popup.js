document.getElementById('saveTone').addEventListener('click', () => {
  const selectedTone = document.getElementById('toneSelect').value;
  chrome.storage.local.set({ tone: selectedTone }, () => {
    alert('Tone preference saved!');
  });
});

// Optional: Load saved tone when opening the popup
document.addEventListener('DOMContentLoaded', () => {
  chrome.storage.local.get('tone', (data) => {
    if (data.tone) {
      document.getElementById('toneSelect').value = data.tone;
    }
  });
});
