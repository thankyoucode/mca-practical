<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\PhoneController;

Route::get('/', function () {
    return view('welcome');
});

Route::get('/test', function () {
    return "Laravel setup is working";
});

Route::get('/phones', [PhoneController::class, 'index']);