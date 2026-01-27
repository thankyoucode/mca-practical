<?php
$postTitle = "How to Upload Files Using PHP";
$postAuthor = "Kishan Jat";
$postCategory = "Programming";
$postViews = 850;
$postContent = "Uploading files with PHP is simple. You create a form with an input of type 'file', submit it via POST, and handle the upload in PHP using \$_FILES. Then you can move the uploaded file to a folder with move_uploaded_file().";

if($postViews > 1000){
  $popularity = "Popular Post";
}elseif($postViews > 500){
  $popularity = "Trending";
}else{
  $popularity = "New Post";
}
switch($postCategory){
  case "Programming":
    $categoryMsg = "Practical Code Explanation";
    break;
  case "Tech":
    $categoryMsg = "Latest technology updates";
    break;
  case "Lifestyle":
    $categoryMsg = "Tips for better living";
    break;
  case "Travel":
    $categoryMsg = "Explore new places";
    break;
  default:
    $categoryMsg = "General news";
    break;
}
?>
<!DOCTYPE html>
<html>
<head>
  <title>Media Blog</title>
  <style>
    body{font-family:Arial;line-height:1.6;background:#f0f0f0;color:#333;s}
    .container{max-width:700px;margin:0 auto;background:#fff;padding:8px;border-radius:6px;}
    h1{margin-bottom:10px;color:#222;}
    .meta{color:#555;margin-bottom:15px;}
    .popularity{color:#e74c3c;font-weight:bold;}
    .category{color:#3498db;}
    p{margin-bottom:15px;}
    pre{background:#eee;padding:10px;border-radius:4px;overflow-x:auto;}
  </style>
</head>
<body>
  <div class="container">
    <h1><?= htmlspecialchars($postTitle) ?></h1>
    <div class="meta">
      Author: <?= htmlspecialchars($postAuthor) ?> | 
      Category: <span class="category"><?= htmlspecialchars($postCategory) ?></span> | 
      Views: <?= $postViews ?> | 
      <span class="popularity"><?= $popularity ?></span>
    </div>
    <p><?= htmlspecialchars($postContent) ?></p>
    <p><em><?= $categoryMsg ?></em></p>
    <h2>Simple PHP File Upload Example</h2>
    <p>Below is the minimal code to upload a file:</p>
    <pre>
&lt;?php
if(isset($_FILES['file'])){
  $uploadDir = 'uploads/';
  if(!is_dir($uploadDir)) mkdir($uploadDir);
  $filePath = $uploadDir . basename($_FILES['file']['name']);
  move_uploaded_file($_FILES['file']['tmp_name'], $filePath);
  echo "File uploaded successfully!";
}
?&gt;
&lt;form method="post" enctype="multipart/form-data"&gt;
  &lt;input type="file" name="file"&gt;
  &lt;button type="submit"&gt;Upload&lt;/button&gt;
&lt;/form&gt;
    </pre>
    <p>This code creates a folder <strong>uploads/</strong> if it doesn't exist, moves the uploaded file there, and shows a success message. Always use <code>enctype="multipart/form-data"</code> in the form.</p>
  </div>
</body>
</html>
