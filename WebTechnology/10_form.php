<!--
mkdir uploads
chmod 777 uploads

php -S localhost:8000
http://localhost:8000/10_form.php
-->

<?php
$imagePath = $title = $description = '';
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
  $title = $_POST['title'] ?? '';
  $description = $_POST['description'] ?? '';
  // Handling image upload
  if (isset($_FILES['image']) && $_FILES['image']['error'] === 0) {
    $uploadDir = 'uploads/';
    if (!is_dir($uploadDir)) mkdir($uploadDir);
    $imagePath = $uploadDir . basename($_FILES['image']['name']);
    move_uploaded_file($_FILES['image']['tmp_name'], $imagePath);
  }
}
?>
<!DOCTYPE html>
<html>
<head>
  <title>YouTube Video Preview</title>
  <style>
    body { font-family: Arial; background: #f5f5f5; color: #333; display: flex; padding: 20px; } 
    .form-container { flex: 1; padding-right: 20px; } 
    .preview { flex: 1; background: #fff; padding: 15px; border-radius: 8px; border: 1px solid #ccc; } 
    input, textarea { width: 100%; margin: 5px 0; padding: 8px; border-radius: 4px; border: 1px solid #ccc; background: #fff; color: #333; } 
    input[type=file] { padding: 3px; } 
    .video-img { width: 100%; height: auto; border-radius: 4px; margin-bottom: 10px; } 
    h3 { margin: 5px 0; color: #111; } 
    p { margin: 0; font-size: 14px; color: #555; }
  </style>
</head>
<body>
<div class="form-container">
  <h2>Upload Video</h2>
  <form method="post" enctype="multipart/form-data" id="videoForm">
    <label>Image:</label>
    <input type="file" name="image" id="imageInput" accept="image/*" required>
    <label>Title:</label>
    <input type="text" name="title" id="titleInput" placeholder="Enter title" required>
    <label>Description:</label>
    <textarea name="description" id="descInput" rows="4" placeholder="Enter description" required></textarea>
    <button type="submit">Upload</button>
  </form>
</div>
<div class="preview">
  <h2>Preview</h2>
  <?php if ($imagePath): ?>
    <img src="<?= htmlspecialchars($imagePath) ?>" class="video-img" id="previewImage">
  <?php else: ?>
    <img src="" class="video-img" id="previewImage" style="display:none;">
  <?php endif; ?>
  <h3 id="previewTitle"><?= htmlspecialchars($title) ?: 'Video Title' ?></h3>
  <p id="previewDesc"><?= htmlspecialchars($description) ?: 'Video description...' ?></p>
</div>
<script>
  const imageInput = document.getElementById('imageInput');
  const titleInput = document.getElementById('titleInput');
  const descInput = document.getElementById('descInput');

  const previewImage = document.getElementById('previewImage');
  const previewTitle = document.getElementById('previewTitle');
  const previewDesc = document.getElementById('previewDesc');

  imageInput.addEventListener('change', function(){
    const file = this.files[0];
    if(file){
      const reader = new FileReader();
      reader.onload = function(e){
        previewImage.src = e.target.result;
        previewImage.style.display = 'block';
      }
      reader.readAsDataURL(file);
    }
  });
  titleInput.addEventListener('input', function(){
    previewTitle.textContent = this.value || 'Video Title';
  });
  descInput.addEventListener('input', function(){
    previewDesc.textContent = this.value || 'Video description...';
  });
</script>
</body>
</html>
