package org.academiadecodigo.gnunas.fivehundredmilestolearn;

public enum Questions {

    QUESTION1("Quantas unidades há em uma dúzia?", "12", "10", "6"),
    QUESTION2("Quantas unidades há em uma dezena?","10", "12","6"),
    QUESTION3("Quantas unidades há em meia dúzia?", "6", "10", "12"),
    QUESTION4("Quantas unidades há em uma centena?","100", "10","1000"),
    QUESTION5("Qual o resultado da soma 7 + 3?", "10", "11", "9"),
    QUESTION6("Quantos lados tem um triângulo?","3", "4","2"),
    QUESTION7("Quantos lados tem um quadrado?", "4", "3", "2"),
    QUESTION8("Qual o maior entre os números:","21", "11","12"),
    QUESTION9("Qual o menor entre os números:", "11", "12", "21"),
    QUESTION10("Qual destes ∉ a um conjunto de números:","O", "0","3"),
    QUESTION11("Qual o resultado da subtração 7 - 2?", "5", "4", "6"),
    QUESTION12("Qual o resultado da soma 2 + 7?","9", "10","8"),
    QUESTION13("Qual destes ∈ a um conjunto de números:", "0", "O", "A"),
    QUESTION14("Qual a expressão correta:","8 > 6", "8 < 6","8 = 6"),
    QUESTION15("Qual o símbolo da soma:", "+", "-", "*"),
    QUESTION16("Qual o símbolo da subtração: ","-", "+","#"),
    QUESTION17("Como se lê o número 2?", "dois", "dez", "sete"),
    QUESTION18("Como se lê o número 7?","sete", "seis","cinco"),
    QUESTION19("Qual o resultado da subtração 10 - 4?", "6", "7", "5"),
    QUESTION20("Qual o resultado da subtração 9 - 5?","4", "3","6"),

    QUESTION21("Quantas vezes aparece a letra “a”, na palavra batata?", "3", "2", "4"),
    QUESTION22("Qual das palavras a seguir começa com a letra B", "BOLA", "CASA", "DADO"),
    QUESTION23("Quantas letras tem a palavra CAVALO", "6", "5", "7"),
    QUESTION24("Qual símbolo usamos no final de uma pergunta?", "?", "!", "#"),
    QUESTION25("Qual das letras a seguir é uma vogal?", "E", "F", "R"),
    QUESTION26("Qual das letras a seguir não é uma vogal?", "L", "I", "U"),
    QUESTION27("Qual das palavras a seguir termina com a letra R", "COMER", "RAMA", "CAMA"),
    QUESTION28("Qual das palavras a seguir começa com a letra D", "DEDO", "BELO", "TATU"),
    QUESTION29("Qual das palavras a seguir começa com a letra F", "FOCA", "COLA", "ELA"),
    QUESTION30("Qual das palavras a seguir começa com a letra G", "GATO", "RATO", "JOÃO"),
    QUESTION31("Qual das palavras a seguir termina com a letra E ", "LIVRE", "LIVRO", "LETRA"),
    QUESTION32("Qual das palavras a seguir começa com a letra L", "LATA", "BATATA", "COLA"),
    QUESTION33("Qual das palavras a seguir começa com a letra M", "MOLA", "BOLA", "NAVIO"),
    QUESTION34("Qual das palavras a seguir começa com a letra N", "NEVE", "MOLA", "MICO"),
    QUESTION35("Qual das palavras a seguir começa com a letra P", "PATO", "FOCA", "RETA"),
    QUESTION36("Qual das palavras a seguir começa com a letra S", "SOPA", "CESTO", "PATO"),
    QUESTION37("Qual das palavras a seguir começa com a letra T", "TIA", "DIA", "RIA"),
    QUESTION38("Qual das palavras a seguir começa com a letra V", "VER", "SER", "TER"),
    QUESTION39("Qual das palavras a seguir começa com a letra Q", "QUEIJO", "OVO", "CASA"),
    QUESTION40("Quantas sílabas tem a palavra BANANA", "3", "6", "5"),


    QUESTION41("Como se escreve GATO em inglês?", "CAT", "DOG", "MOUSE"),
    QUESTION42("Como se escreve CÃO em inglês?", "DOG", "CAT", "MOUSE"),
    QUESTION43("Como se escreve MAÇÃ em inglês?", "APPLE", "GRAPE", "BANANA"),
    QUESTION44("Como se escreve LÁPIS em inglês?", "PENCIL", "PEN", "PEAR"),
    QUESTION45("Como se escreve ÁGUA em inglês?", "WATER", "APPLE", "BANANA"),
    QUESTION46("O que devemos fazer após usar a casa de banho?", "Lavar as mãos", "Jogar videojogos", "Assistir TV"),
    QUESTION47("Qual destes alimentos é o mais saudável?", "FRUTAS", "REFRIGERANTE", "BATATA FRITA"),
    QUESTION48("Qual destas bebidas devemos EVITAR?", "REFRIGERANTE", "SUMO DE FRUTA", "LEITE"),
    QUESTION49("Qual destes alimentos devemos EVITAR?", "BALAS E GULOSEIMAS", "FRUTAS", "LEGUMES"),
    QUESTION50("O que podemos fazer para evitar as cáries?", "ESCOVAR BEM OS DENTES", "COMER MUITOS DOCES", "NÃO IR AO DENTISTA"),
    QUESTION51("Qual desses profissionais é  o responsável por cuidar dos doentes?", "MÉDICO", "PROFESSOR", "BAILARINA"),
    QUESTION52("Qual desses profissionais é o responsável por ensinar?", "PROFESSOR", "MÚSICO", "BOMBEIRO"),
    QUESTION53("Qual o número que devemos ligar em caso de EMERGÊNCIA?", "112", "911", "500"),
    QUESTION54("Como se escreve PÊRA em inglês?", "PEAR", "APPLE", "ORANGE"),
    QUESTION55("Como se escreve LARANJA em inglês?", "ORANGE", "PEAR", "BANANA"),
    QUESTION56("Como se escreve BANANA em inglês?", "BANANA", "ORANGE", "PEAR"),
    QUESTION57("Quantas vezes devemos escovar os dentes no mínimo?", "3", "1", "2"),
    QUESTION58("O que devemos usar para lavar o cabelo?", "Champô", "Pasta dentífrica", "Detergente"),
    QUESTION59("O que nunca deve ser ingerido?", "Lixívia", "Refrigerante", "Café");

    private String question;
    private String correctAnswer;
    private String wrongAnswer1;
    private String wrongAnswer2;

    Questions(String question, String correctAnswer, String wrongAnswer1, String wrongAnswer2) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.wrongAnswer1 = wrongAnswer1;
        this.wrongAnswer2 = wrongAnswer2;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getWrongAnswer1() {
        return wrongAnswer1;
    }

    public void setWrongAnswer1(String wrongAnswer1) {
        this.wrongAnswer1 = wrongAnswer1;
    }

    public String getWrongAnswer2() {
        return wrongAnswer2;
    }

    public void setWrongAnswer2(String wrongAnswer2) {
        this.wrongAnswer2 = wrongAnswer2;
    }
}
