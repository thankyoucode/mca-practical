// Convert distance in km to meters, feet, inches, and centimeters.
// tags: conversion, math

#include <stdio.h>

void main() {
    float km, m, feet, inches, cm;
    printf("Enter distance in km: ");
    scanf("%f", &km);
    m = km * 1000;
    feet = km * 3280.84;
    inches = km * 39370.08;
    cm = km * 100000;
    printf("Meters: %.2f\nFeet: %.2f\nInches: %.2f\nCentimeters: %.2f\n", m, feet, inches, cm);
}