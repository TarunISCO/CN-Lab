#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char *argv[]){
	
	int check = 1;
	int i = 0, d = 0, bt_index = 0;
	char bt[3];
	for( ; i < strlen(argv[1]) && check == 1; i++) {
		if( argv[1][i] == '.') {
			d++;
			bt_index = 0;
			int n = atoi(bt);
			if( n < 0 || n > 255)
				check = 0;
		}
		else {
			bt[bt_index] = argv[1][i];
			bt_index++;
		}
	}
	if( d != 3)
		check = 0;
	if( check == 0) {
		printf("Wrong address!!!\n");
		return 0;
	}
	char byte[3];
	i =0;
	while( i < 3 && argv[1][i] != '.') {
		byte[i] = argv[1][i];
		i++;
	}
	int n = atoi(byte);
	i = 0; 
	d = 0;
	if(n >= 1 && n <= 126){
        printf("Class A\n");
        printf("Network ID : ");
        while(d < 1) {
        	if( argv[1][i] == '.') 
        		d++;
        	printf("%c" , argv[1][i]);
        	i++;
        }
        printf("\nHost Address : ");
        for (; i < strlen(argv[1]); i++)
        	printf("%c", argv[1][i]);
        printf("\n");
	}
    else if(n >= 128 && n <= 191){
        printf("Class B\n");
        printf("Network ID : ");
        while(d < 2) {
        	if( argv[1][i] == '.') 
        		d++;
        	printf("%c" , argv[1][i]);
        	i++;
        }
        printf("\nHost Address : ");
        for (; i < strlen(argv[1]); i++)
        	printf("%c", argv[1][i]);
        printf("\n");
    }
    else if(n >= 192 && n <= 223) {
        printf("Class C\n");
        printf("Network ID : ");
        while(d < 3) {
        	if( argv[1][i] == '.') 
        		d++;
        	printf("%c" , argv[1][i]);
        	i++;
        }
        printf("\nHost Address : ");
        for (; i < strlen(argv[1]); i++)
        	printf("%c", argv[1][i]);
        printf("\n");
    }
    else if(n >= 224 && n <= 229) {
        printf("Class D\n");
        printf("Network ID : ");
        for (; i < strlen(argv[1]); i++)
        	printf("%c", argv[1][i]);
        printf("\n");
    }
    else if(n >= 240 && n <= 255) {
        printf("Class E\n");
        printf("Network ID : ");
        for (; i < strlen(argv[1]); i++)
        	printf("%c", argv[1][i]);
        printf("\n");
    }
    else
        printf("Wrong address\n");

    return 0;
}