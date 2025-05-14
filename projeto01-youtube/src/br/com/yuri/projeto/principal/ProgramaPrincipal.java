package br.com.yuri.projeto.principal;

import br.com.yuri.projeto.visualizacao.InteracaoVisual;
import br.com.yuri.projeto.modelo.*;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.yuri.projeto.dao.*;

public class ProgramaPrincipal {
    public static void main(String[] args) {
        //Criação dos vetores
        Gafanhoto g[] = new Gafanhoto [3];
        Video v[] = new Video[3];
        InteracaoVisual ver[] = new InteracaoVisual[5];
        
        // Alunos
      /*   g[0] = new Gafanhoto("Carlos", "M", 12, "Carlos.f");
        g[1] = new Gafanhoto("Maria", "F", 25, "Maria.f");
        g[2] = new Gafanhoto("Jubiscleudon", "M", 29, "Jub.f");
      */
        
        // Videos
        /* v [0] = new Video("Aula 01 POO");
        v [1] = new Video("Aula 12 de PHP");
        v [2] = new Video("Aula 10 de HTML5"); */
        
        //Relatorios dos videos quando iniciados
        /*  System.out.println(v[0].toString());
        System.out.println(v[1].toString());
        System.out.println(v[2].toString()); */
        

        //Relatorio dos espectadores(gafanhotos) ANTES de assistir os videos
        /* System.out.println();
        System.out.println(g[0].toString());
        System.out.println(g[1].toString());
        System.out.println(g[2].toString());     
         */

        // Interação entre aluno e video
      /*   ver[0] = new Visualizacao(g[0], v[0]);
        ver[0].avaliar(40.0f);
        ver[1] = new Visualizacao(g[1], v[0]);
        ver[1].avaliar();
        ver[2] = new Visualizacao(g[2], v[0]);
        ver[2].avaliar();
        ver[3] = new Visualizacao(g[0], v[1]);
        ver[4] = new Visualizacao(g[1], v[2]); */
        //inserindo alunos no banco de dados
        

        

        //Relatorio dos espectadores(gafanhotos) DEPOIS de assistir os videos
        /* System.out.println();
        System.out.println(g[0].toString());
        System.out.println(g[1].toString());
        System.out.println(g[2].toString()); */

        //Relatorio da interação 
        /* System.out.println();
        System.out.println(ver[0].toString());
        System.out.println(ver[1].toString());
        System.out.println(ver[2].toString());
        System.out.println(ver[3].toString());
        System.out.println(ver[4].toString()); */
        
        //Relatorios dos videos quando assistidos
        /* System.out.println("-------------------------------");
        System.out.println("RELATORIO DOS VIDEOS ASSISTIDOS");
        System.out.println(v[0].toString());
        System.out.println(v[1].toString());
        System.out.println(v[2].toString()); */
        
        // Nomes das pessoas que assistiram o videos
        /* System.out.println("---ESPECTADORES-----");
        v[0].listarEspectadores();
        v[1].listarEspectadores();
        v[2].listarEspectadores(); */
        
    }
}