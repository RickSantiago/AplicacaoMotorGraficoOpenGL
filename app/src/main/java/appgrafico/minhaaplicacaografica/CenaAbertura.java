package appgrafico.minhaaplicacaografica;

import appgrafico.minhaaplicacaografica.AndGraph.AGGameManager;
import appgrafico.minhaaplicacaografica.AndGraph.AGInputManager;
import appgrafico.minhaaplicacaografica.AndGraph.AGScene;
import appgrafico.minhaaplicacaografica.AndGraph.AGScreenManager;
import appgrafico.minhaaplicacaografica.AndGraph.AGSoundManager;
import appgrafico.minhaaplicacaografica.AndGraph.AGSprite;
import appgrafico.minhaaplicacaografica.AndGraph.AGTimer;

/**
 * Created by RickSantiago on 24/10/2016.
 */
public class CenaAbertura extends AGScene {
    AGTimer intervaloTempo = null;
    AGSprite vrImagem = null;
    int estado = 0;

    public CenaAbertura(AGGameManager gerente) {
        super(gerente);
    }

    @Override
    public void init() {
        //criar uma cena com o fundo amarelo
        this.setSceneBackgroundColor(1, 1, 1);
        intervaloTempo = new AGTimer(4000);
        vrImagem = createSprite(R.mipmap.start, 1, 1);
        vrImagem.setScreenPercent(30, 20);
        vrImagem.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight - (AGScreenManager.iScreenHeight / 4));

        AGSoundManager.vrMusic.loadMusic("musicapurple.mp3", true);
        AGSoundManager.vrMusic.pause();
    }

    @Override
    public void restart() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void loop() {

        if (AGInputManager.vrTouchEvents.screenClicked())
        {
            if(vrImagem.collide(AGInputManager.vrTouchEvents.getLastPosition()))
            {
                vrGameManager.setCurrentScene(2);
                return;
            }
        }

//        if(estado == 0)
//        {
//            if (vrSair.fadeEnded())
//            {
//                vrSair.fadeOut(3000);
//                estado = 1;
//            }
//        }
//        else
//        {
//            if (vrSair.fadeEnded())
//            {
//               vrGameManager.setCurrentScene(1);
//                return;
//            }
//        }

//        intervaloTempo.update();
//
//        if (intervaloTempo.isTimeEnded())
//        {
//            vrGameManager.setCurrentScene(1);
//            return;
//        }
//        if (AGInputManager.vrTouchEvents.screenClicked())
//        {
//            vrGameManager.setCurrentScene(1);
//            return;
//        }
//    }
    }
}
