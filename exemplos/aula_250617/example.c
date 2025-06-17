#include <stdio.h>

FILE* abrir_arquivo(const char* nome) {
    FILE* arquivo = fopen(nome, "r");
    if (arquivo == NULL) {
        printf("Erro ao abrir o arquivo");
        return NULL;
    }
    return arquivo;
}

int main(){
    FILE* arquivo = abrir_arquivo("exemplo.txt");
    if (arquivo == NULL) {
        return 1; // Retorna 1 se houve erro ao abrir o arquivo
    }

    printf("Continundo o processamemto, tentando novamente!\n");
    // Aqui você pode adicionar código para ler do arquivo, processar dados, etc.

    fclose(arquivo); // Fecha o arquivo após o uso
    return 0; // Retorna 0 para indicar sucesso
}