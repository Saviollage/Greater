# Maior elemento de um vetor

[![Run on Repl.it](https://repl.it/badge/github/Saviollage/Greater](https://repl.it/@Saviollage/Greater)

Implementação paralela do algoritmo para encontrar o maior elemento de um vetor.

O algoritmo recebe uma lista de N elementos inteiros, e assim iniciando √N threads, onde cada uma dessas trata uma sublista de N/√N elementos, retornando o maior elemento desta. Os maiores elementos encontrados são tratados da mesma forma pela thread principal, obtendo assim o maior elemento dentre os maiores.

Vale ressaltar o ganho de performace ao utilizar paralelismo em relação à algoritmos lineares


## License
[MIT](https://choosealicense.com/licenses/mit/)