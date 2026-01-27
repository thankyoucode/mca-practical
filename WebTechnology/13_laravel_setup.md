# 13. Laravel Setup: Set up a Laravel development environment and create a simple application using Artisan commands.

## Laravel Setup and Simple Application Using Artisan

Laravel is a PHP framework used to develop web applications in an easy and structured way.
It follows MVC (Model View Controller) architecture and provides many built-in features.
In this practical, the goal is to set up Laravel development environment and create a simple application using Artisan commands.

I going to setup Laravel project in Ubuntu that i am using

Setup need PHP and Composer

### Installing PHP and Composer

```bash
apt install php-cli php-mbstring php-xml php-bcmath php-curl php-zip unzip
php -v

php -r "copy('https://getcomposer.org/installer', 'composer-setup.php');"
sudo php composer-setup.php --install-dir=/usr/local/bin --filename=composer

php -r "unlink('composer-setup.php');"

composer --version
```

### Creating Laravel Project

Laravel project is created using Composer command.
This command downloads Laravel and prepares complete project structure.
creating laravel application inside `laravel` folder that also present here in this repo with code include program 13, 14, 15

[myApp](laravel/myApp/)

```bash
composer create-project laravel/laravel myApp
```

After this command, a new folder named `myApp` is created.

### Running Laravel Application

go to `myApp` project directory

```bash
cd myApp
```

- `routes/` - application routes
- `app/` - controllers and application logic
- `resources/views/` - view files contain html+php (Blade) templates
- `public/` - public assets like css media(images, videos), fonts, any thing else

first time run this for setup and dependancy install

```bash
composer install
```

and run Laravel development server using Artisan

```bash
php artisan serve
```

Open that local URL if it show Laravel welcome page setup is successful.

may error come like this

```plaintext
Illuminate\Encryption\MissingAppKeyException
vendor/laravel/framework/src/Illuminate/Encryption/EncryptionServiceProvider.php:83
No application encryption key has been specified.
LARAVEL 12.48.1
PHP 8.3.6
UNHANDLED
CODE 0
```

let fix it, run this that automaticaly add key to .env file

```bash
php artisan key:generate
```

previous problem fix but new one come

```plaintext
Illuminate\Database\QueryException
vendor/laravel/framework/src/Illuminate/Database/Connection.php:838

Database file at path [/home/jatkishan/Education/MCA/SEM-1/webtechnology/Practical/laravel/myApp/database/database.sqlite] does not exist. Ensure this is an absolute path to the database. (Connection: sqlite, Database: /home/jatkishan/Education/MCA/SEM-1/webtechnology/Practical/laravel/myApp/database/database.sqlite, SQL: select * from "sessions" where "id" = 4JjJ0F13ltc4VDzlxM1Hx4MqdcwrLaf8xubYByv8 limit 1)
```

i am going to use `SQLite`

first create database file

```bash
touch database/database.sqlite
```

in `.env` update this variable

```plaintext
DB_DATABASE=myApp/database/database.sqlite
```

using sqlite database but there php dependency is not installed let install it

```bash
sudo apt install php-sqlite3
```

now it works

```bash
php artisan migrate
php artisan config:clear
php artisan serve
```

### Understanding Artisan

Artisan is Laravel’s command line tool.
It is used to create files, run server, clear cache, and manage application tasks.

To see all available Artisan commands

```bash
php artisan list
```

### Creating Simple Route

Open `routes/web.php` and add

```php
Route::get('/test', function () {
  return "Laravel setup is working";
});
```

here `http://127.0.0.1:8000/test` we can see this route result.
