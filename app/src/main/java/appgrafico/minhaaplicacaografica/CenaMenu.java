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
public class CenaMenu extends AGScene
{
    AGTimer intervaloTempo = null;
    AGSprite vrSair = null;
    AGSprite vrIniciar = null;
    AGSprite vrOpcao = null;
    int estado = 0;
    int codigoSom = 0;

    public CenaMenu(AGGameManager gerente)
    {
        super(gerente);
    }

    @Override
    public void init()
    {
        this.setSceneBackgroundColor(1, 1, 1);
        vrOpcao = createSprite(R.mipmap.settings, 1, 1);
        vrOpcao.setScreenPercent(30, 20);
        vrOpcao.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight / 2);
        codigoSom = AGSoundManager.vrSoundEffects.loadSoundEffect("efeitosonoro.mp3");

        vrSair = createSprite(R.mipmap.exit, 1, 1);
        vrSair.setScreenPercent(30, 20);
        vrSair.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight / 4);

        vrIniciar = createSprite(R.mipmap.start, 1, 1);
        vrIniciar.setScreenPercent(30, 20);
        vrIniciar.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight - (AGScreenManager.iScreenHeight / 4));

        AGSoundManager.vrMusic.loadMusic("musicapurple.mp3", true);
        AGSoundManager.vrMusic.pause();
    }

    @Override
    public void restart()
    {

    }

    @Override
    public void stop()
    {

    }

    @Override
    public void loop()
    {
//
//        if (AGInputManager.vrTouchEvents.screenClicked() || AGInputManager.vrTouchEvents.backButtonClicked())
//        {
//            vrGameManager.setCurrentScene(0);
//            return;
//        }
        if(AGInputManager.vrTouchEvents.screenClicked())
        {
            if(vrOpcao.collide(AGInputManager.vrTouchEvents.getLastPosition()))
            {
                vrGameManager.setCurrentScene(1);
                AGSoundManager.vrSoundEffects.play(codigoSom);
                return;
            }
            if(vrIniciar.collide(AGInputManager.vrTouchEvents.getLastPosition()))
            {
                vrGameManager.setCurrentScene(2);
                return;
            }
            if(vrSair.collide(AGInputManager.vrTouchEvents.getLastPosition()))
            {
                System.exit(0);
                return;
            }

        }


    }
}
