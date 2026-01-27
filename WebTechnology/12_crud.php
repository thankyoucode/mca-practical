<!-- 
sudo systemctl start mysql

sudo mysql
SHOW DATABASES;
-->

<?php
$host = "localhost";
$user = "root";
$pass = "";
$db = "youtube_clone";
$conn = new mysqli($host, $user, $pass, $db);
if($conn->connect_error){ die("Connection failed: ".$conn->connect_error); }
$watchVideo = null;
if (isset($_GET['watch'])) {
  $id = (int)$_GET['watch'];
  $res = $conn->query("SELECT * FROM videos WHERE id=$id");
  $watchVideo = $res->fetch_assoc();
}
// Upload
if(isset($_POST['upload'])){
  $title = $_POST['title'];
  $desc = $_POST['description'];
  if(isset($_FILES['video']) && $_FILES['video']['error']==0){
    $uploadDir='uploads/';
    if(!is_dir($uploadDir)) mkdir($uploadDir);
    $filename=time().'_'.basename($_FILES['video']['name']);
    $filepath=$uploadDir.$filename;
    if(move_uploaded_file($_FILES['video']['tmp_name'],$filepath)){
      $stmt=$conn->prepare("INSERT INTO videos(title,description,filename) VALUES(?,?,?)");
      $stmt->bind_param("sss",$title,$desc,$filename);
      $stmt->execute();
      $stmt->close();
      $message="Video uploaded successfully!";
    }else{ $message="Upload failed"; }
  }else{ $message="No video selected"; }
}

// Delete
if(isset($_GET['delete'])){
  $id=(int)$_GET['delete'];
  $result=$conn->query("SELECT filename FROM videos WHERE id=$id");
  if($row=$result->fetch_assoc()){
    if(file_exists('uploads/'.$row['filename'])) unlink('uploads/'.$row['filename']);
    $conn->query("DELETE FROM videos WHERE id=$id");
  }
}
// Edit
if(isset($_POST['edit'])){
  $id=(int)$_POST['id'];
  $title=$_POST['title'];
  $desc=$_POST['description'];
  $stmt=$conn->prepare("UPDATE videos SET title=?, description=? WHERE id=?");
  $stmt->bind_param("ssi",$title,$desc,$id);
  $stmt->execute();
  $stmt->close();
  $message="Video updated!";
}
// Fetch video for editing
$editVideo=null;
if(isset($_GET['edit'])){
  $id=(int)$_GET['edit'];
  $res=$conn->query("SELECT * FROM videos WHERE id=$id");
  $editVideo=$res->fetch_assoc();
}
?>
<!DOCTYPE html>
<html>
<head>
<title>YouTube Clone CRUD</title>
<style>
body{font-family:Arial;background:#f5f5f5;padding:20px;}
.container{max-width:900px;margin:0 auto;}
form{background:#fff;padding:15px;border-radius:6px;margin-bottom:20px;}
input,textarea{width:100%;margin:5px 0;padding:8px;border-radius:4px;border:1px solid #ccc;}
button{padding:8px 15px;margin-top:5px;}
.video{background:#fff;padding:15px;margin-bottom:15px;border-radius:6px;}
video{width:100%;max-height:400px;border-radius:4px;}
.layout{display:flex;gap:20px;}
.sidebar{width:250px;background:#fff;padding:10px;border-radius:6px;}
.main{flex:1;background:#fff;padding:15px;border-radius:6px;}
.sidebar a{display:block;padding:6px 0;color:#333;text-decoration:none;}
.sidebar a:hover{text-decoration:underline;}
</style>
</head>
<body>
<div class="container">
<h1>YouTube Clone CRUD</h1>
<?php if(isset($message)) echo "<p>$message</p>"; ?>
<?php if($editVideo): ?>
<form method="post">
  <input type="hidden" name="id" value="<?= $editVideo['id'] ?>">
  <input type="text" name="title" value="<?= htmlspecialchars($editVideo['title']) ?>" required>
  <textarea name="description" required><?= htmlspecialchars($editVideo['description']) ?></textarea>
  <button type="submit" name="edit">Update Video</button>
  <a href="youtube_crud.php">Cancel</a>
</form>
<?php else: ?>
<form method="post" enctype="multipart/form-data">
  <input type="text" name="title" placeholder="Video Title" required>
  <textarea name="description" placeholder="Video Description" required></textarea>
  <input type="file" name="video" accept="video/*" required>
  <button type="submit" name="upload">Upload Video</button>
</form>
<?php endif; ?>
<?php
$result=$conn->query("SELECT * FROM videos ORDER BY uploaded_at DESC");
while($video=$result->fetch_assoc()){
  echo '<div class="video">';
  echo '<h3>'.htmlspecialchars($video['title']).'</h3>';
  echo '<p>'.htmlspecialchars($video['description']).'</p>';
  echo '<video controls src="uploads/'.$video['filename'].'"></video><br>';
  echo '<a href="?edit='.$video['id'].'">Edit</a> | ';
  echo '<a href="?delete='.$video['id'].'" onclick="return confirm(\'Delete this video?\')">Delete</a>';
  echo '</div>';
}
?>
</div>
<!-- Videos List -->
<div class="layout">
  <div class="sidebar">
  <h3>Videos</h3>
  <?php
  $list = $conn->query("SELECT id,title FROM videos ORDER BY uploaded_at DESC");
  while($v = $list->fetch_assoc()){
    echo '<a href="?watch='.$v['id'].'">'.htmlspecialchars($v['title']).'</a>';
  }
  ?>
  </div>
  <!-- Watch video -->
  <div class="main">
  <?php if($watchVideo): ?>
    <h2><?= htmlspecialchars($watchVideo['title']) ?></h2>
    <p><?= htmlspecialchars($watchVideo['description']) ?></p>
    <video controls autoplay style="width:100%;max-height:500px;">
      <source src="uploads/<?= $watchVideo['filename'] ?>">
    </video>
  <?php else: ?>
    <p>Select a video to play</p>
  <?php endif; ?>
  <?php $conn->close(); ?>
  </div>
</div>
</body>
</html>
