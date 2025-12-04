// Delete spaces from file and write into new file.
// tags: files, string

#include <stdio.h>
#include <stdlib.h>

void remove_spaces(char *input_file, char *output_file) {
    FILE *input = fopen(input_file, "r");
    FILE *output = fopen(output_file, "w");
    
    char ch;
    while ((ch = fgetc(input)) != EOF) {
        if (ch != ' ') {
            fputc(ch, output);
        }
    }
    fclose(input);
    fclose(output);
}

int main() {
    remove_spaces("50_file_remove_spaces.c", "50_file_remove_spaces.c.txt");
    printf("All spaces remove and write to %s\n", "50_file_remove_spaces.c.txt");
    return 0;
}
