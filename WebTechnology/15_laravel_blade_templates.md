### Creating new view for PhoneList

```bash
php artisan make:view phones.index
```

`resources/views/phones/index.blade.php` code that get Phone object form controller and show here.

```php
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Phone List</title>
  <style>
    body { font-family: Arial, sans-serif; padding: 20px; }
    table { width: 60%; border-collapse: collapse; margin-top: 20px; }
    th, td { border: 1px solid #ddd; padding: 10px; text-align: left; }
    th { background-color: #f2f2f2; }
  </style>
</head>
<body>
  <h1>Phone Models and there Prices in India</h1>
  <table>
    <tr>
      <th>Model</th>
      <th>Price (₹)</th>
    </tr>
    @foreach($phones as $phone)
    <tr>
      <td>{{ $phone->model }}</td>
      <td>₹{{ number_format($phone->price, 0) }}</td>
    </tr>
    @endforeach
  </table>
</body>
</html>
```
