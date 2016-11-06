package appgrafico.minhaaplicacaografica;

import appgrafico.minhaaplicacaografica.AndGraph.AGGameManager;
import appgrafico.minhaaplicacaografica.AndGraph.AGInputManager;
import appgrafico.minhaaplicacaografica.AndGraph.AGScene;
import appgrafico.minhaaplicacaografica.AndGraph.AGScreenManager;
import appgrafico.minhaaplicacaografica.AndGraph.AGSprite;
import appgrafico.minhaaplicacaografica.AndGraph.AGTimer;

/**
 * Created by RickSantiago on 24/10/2016.
 */
public class CenaEmBranco extends AGScene {
    AGTimer intervaloTempo = null;
    AGSprite cena = null;
    AGSprite cena2 = null;
    int estado = 0;
    AGSprite meninoCorrendo = null;

    public CenaEmBranco(AGGameManager gerente) {
        super(gerente);
    }

    @Override
    public void init() {
        //criar uma cena com o fundo amarelo
        this.setSceneBackgroundColor(1, 1, 1);

        cena = createSprite(R.mipmap.cenafundo, 1, 1);
        cena.setScreenPercent(100, 100);
        cena.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight - (AGScreenManager.iScreenHeight / 4));

        cena2 = createSprite(R.mipmap.cenafundo2, 1, 1);
        cena2.setScreenPercent(100, 100);
        cena2.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight - (AGScreenManager.iScreenHeight / 4));

        meninoCorrendo = createSprite(R.mipmap.actionstashhd, 16, 16);
        meninoCorrendo.addAnimation(15, true, 0, 255);
        meninoCorrendo.setScreenPercent(60, 40);
        meninoCorrendo.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight - (AGScreenManager.iScreenHeight / 2));

    }

    @Override
    public void restart() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void loop() {

        cena.vrPosition.setX(cena.vrPosition.getX() + 5);


        if(cena.vrPosition.getX() > AGScreenManager.iScreenWidth + cena.getSpriteWidth()/2)
        {
            cena.vrPosition.setX(-cena.getSpriteWidth()/2);
        }

        if (AGInputManager.vrTouchEvents.screenClicked() || AGInputManager.vrTouchEvents.backButtonClicked())
        {
            vrGameManager.setCurrentScene(0);
            return;
        }
    }
}
