let imageURL;

function submitHandler() {
  console.log("click");
  const fileInput = document.getElementById('fileInput');
  console.log(fileInput.files);
  const image = fileInput.files[0];

  // Multipart file
  const formData = new FormData();
  formData.append('image_file', image);
  formData.append('size', 'auto');

  const apiKey = "CnbjLASYDARPreTpJgDuRdo1";

  fetch('https://api.remove.bg/v1.0/removebg', {
    method: 'POST',
    headers: {
      'X-Api-Key': apiKey
    },
    body: formData
  })
    .then(function (response) {
      return response.blob();
    })
    .then(function (blob) {
      console.log(blob);
      const url = URL.createObjectURL(blob);
      imageURL = url;

      // Clear previous image
      const processedImageContainer = document.getElementById('processedImageContainer');
      processedImageContainer.innerHTML = '';

      // Create and append the new image
      const img = document.createElement('img');
      img.src = url;
      processedImageContainer.appendChild(img);
    })
    .catch(function (error) {
      console.error('Error:', error);
    });
}

function downloadFile() {
  if (!imageURL) {
    alert('No processed image available to download.');
    return;
  }

  const a = document.createElement('a');
  a.href = imageURL;
  a.download = 'background-removed.png';
  document.body.appendChild(a);
  a.click();
  document.body.removeChild(a);
}
