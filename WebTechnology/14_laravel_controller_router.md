### Creating `PhoneController`

```bash
php artisan make:controller PhoneController
```

`app/Http/Controllers/PhoneController.php`

here i going to use database

1. check that `phones` table is exist if not create with specified schema
2. check in this table any data is present if not add some sample data
3. now read all and return to the view

```php
<?php
namespace App\Http\Controllers;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\DB;
class PhoneController extends Controller {
  public function index() {
    // checking `phones` table exist or not
    // if not creating this with this schema
    if (!Schema::hasTable('phones')) {
      Schema::create('phones', function (Blueprint $table) {
        $table->id();
        $table->string('model');
        $table->integer('price');
        $table->timestamps();
      });
    }
    // checking this table contain records
    // if not then insert this list
    if (DB::table('phones')->count() === 0) {
      $defaultPhones = [
        ['model' => 'Apple iPhone 14', 'price' => 52190, 'created_at' => now(), 'updated_at' => now()],
        ['model' => 'Samsung Galaxy S23 5G', 'price' => 64999, 'created_at' => now(), 'updated_at' => now()],
        ['model' => 'Google Pixel 7', 'price' => 28499, 'created_at' => now(), 'updated_at' => now()],
        ['model' => 'OnePlus 11 5G', 'price' => 32177, 'created_at' => now(), 'updated_at' => now()],
      ];
      DB::table('phones')->insert($defaultPhones);
    }
    // reading all data from phones table and putting to $phones variable
    $phones = DB::table('phones')->get();
    // passing data to phone view that show all detail in web page
    return view('phones.index', compact('phones'));
  }
}
```

### `route/Web.php` Using `PhoneController` here that return phone list from database and that passed to the view `phones.index`

Implementation of `phones.index` come in next `15` practical with Blade Template

```php
use App\Http\Controllers\PhoneController;

Route::get('/phones', [PhoneController::class, 'index']);
```
