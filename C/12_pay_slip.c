// Prepare pay slip using DA,HRA,MA,PF, Gross, Net calculations.
// tags: salary, structures

#include <stdio.h>

void main() {
  struct Salary {
    float basic;
    float da;
    float hra;
    float ma;
    float pf;
    float gross;
    float net;
  };

  struct Salary s;

  printf("Enter basic salary: ");
  scanf("%f", &s.basic);

  s.da = s.basic * 0.10f;       // 10% of basic
  s.hra = s.basic * 0.075f;     // 7.5% of basic
  s.ma = 300;                   // fixed medical allowance
  s.pf = s.basic * 0.125f;      // 12.5% of basic

  s.gross = s.basic + s.da + s.hra + s.ma;
  s.net = s.gross - s.pf;

  printf("\nDA: %.2f\nHRA: %.2f\nMA: %.2f\nPF: %.2f\nGross Salary: %.2f\nNet Salary: %.2f\n",
        s.da, s.hra, s.ma, s.pf, s.gross, s.net);

}
