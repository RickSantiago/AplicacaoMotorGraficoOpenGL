package appgrafico.minhaaplicacaografica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import appgrafico.minhaaplicacaografica.AndGraph.AGActivityGame;
import appgrafico.minhaaplicacaografica.AndGraph.AGGameManager;

public class ActivityPrincipal extends AGActivityGame
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

        //1 - contexto da Aplicacao
        //2 - Habilita ou não o uso do acelerometro
        //3 - Não usar o acelerometo no emulador

        //Intancia do gerente geral do motor
        vrManager = new AGGameManager(this, true);

        //Instancia de uma cena grafica
        CenaAbertura vrCenaAbertura  = new CenaAbertura(vrManager);
        CenaMenu vrCenaMenu  = new CenaMenu(vrManager);
        CenaEmBranco vrCenaEmBranco  = new CenaEmBranco(vrManager);

        //Registra a cena no gerente Geral
        vrManager.addScene(vrCenaMenu);
        vrManager.addScene(vrCenaAbertura);
        vrManager.addScene(vrCenaEmBranco);



    }
}
