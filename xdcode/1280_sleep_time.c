#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	char s[100][20];
	int i = 0;
	int h1, h2, m1, m2, t1, t2, t;
	int len = 0;

	while (gets(s[i]))
	{
		if (s[i][0]=='\0')
			break;
		i++;
	}
	len  = i;
	i = 0;

	while (i<len)
	{
		h1 = (s[i][0]-'0') * 10 + s[i][1]-'0';
		h2 = (s[i][6]-'0') * 10 + s[i][7]-'0';

		m1 = (s[i][3]-'0') * 10 + s[i][4]-'0';
		m2 = (s[i][9]-'0') * 10 + s[i][10]-'0';

		t1 = h1*60 + m1;
		t2 = h2*60 + m2;
		if (t2 >= t1)
		{
			t = t2 - t1;
		}
		else 
		{
			t = 24*60 - t1 + t2;
		}
		printf("%d\n", t);
		i++;
		//printf("%s\n", s[i++]);
	}

	return 0;
}