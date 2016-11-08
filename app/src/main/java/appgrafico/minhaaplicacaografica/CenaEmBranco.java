package appgrafico.minhaaplicacaografica;

import android.util.Log;

import java.util.ArrayList;

import appgrafico.minhaaplicacaografica.AndGraph.AGGameManager;
import appgrafico.minhaaplicacaografica.AndGraph.AGInputManager;
import appgrafico.minhaaplicacaografica.AndGraph.AGScene;
import appgrafico.minhaaplicacaografica.AndGraph.AGScreenManager;
import appgrafico.minhaaplicacaografica.AndGraph.AGSprite;
import appgrafico.minhaaplicacaografica.AndGraph.AGVector2D;

/**
 * Created by RickSantiago on 24/10/2016.
 */
public class CenaEmBranco extends AGScene {

    ArrayList<AGSprite> vetorObjetos = null;
    AGSprite meninoCorrendo = null;
    AGSprite cena = null;
    AGSprite [] placar = null;
    int numeroMenino = 0;

    public CenaEmBranco(AGGameManager gerente) {
        super(gerente);
    }

    @Override
    public void init() {
        //criar uma cena com o fundo amarelo
        this.setSceneBackgroundColor(1, 1, 1);

        cena = createSprite(R.mipmap.cenafundo, 1,1);
        cena.setScreenPercent(30,30);
        cena.bAutoRender = false;
        cena.vrPosition.setXY(AGScreenManager.iScreenWidth/2, AGScreenManager.iScreenHeight/2);
//        cena = createSprite(R.mipmap.cenafundo, 1, 1);
//        cena.setScreenPercent(100, 100);
//        cena.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight - (AGScreenManager.iScreenHeight / 4));

//        cena2 = createSprite(R.mipmap.cenafundo2, 1, 1);
//        cena2.setScreenPercent(100, 100);
//        cena2.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight - (AGScreenManager.iScreenHeight / 4));
        vetorObjetos = new ArrayList<AGSprite>();

        placar = new AGSprite[2];

        for(int i=0; i< placar.length; i++)
        {
            placar[i] = createSprite(R.mipmap.fonte, 4, 4);
            placar[i].bAutoRender = false;
            placar[i].vrPosition.setXY(i * placar[i].getSpriteWidth() + AGScreenManager.iScreenWidth /2, AGScreenManager.iScreenHeight - placar[i].getSpriteHeight()/2);

            for(int quadro = 0; quadro < 10; quadro++)
            {
                placar[i].addAnimation(1, true, quadro);
            }
        }
    }

    //Sobre escreve o metodo de desenho da cena
    public void render()
    {
        super.render();
        cena.render();
        placar[0].render();
        placar[1].render();
    }

    //metodo utilizado para criar imagens/sprites dinamicamente
    public void criaMenino(AGVector2D posicao)
    {
        AGSprite meninoCorrendo = null;

        Log.i("INFO: ", vetorObjetos.size() + " ");

        for(AGSprite meninoCorrendoReciclado:vetorObjetos)
        {
            if(meninoCorrendoReciclado.bRecycled)
            {
                meninoCorrendoReciclado.vrPosition.setXY(posicao.getX(), posicao.getY());
                meninoCorrendoReciclado.bVisible = true;
                meninoCorrendoReciclado.bRecycled = false;
                return;
            }
        }
        meninoCorrendo = createSprite(R.mipmap.actionstashhd, 16, 16);
        meninoCorrendo.addAnimation(15, true, 0, 255);
        meninoCorrendo.setScreenPercent(40, 20);
        meninoCorrendo.vrPosition.setXY(posicao.getX(), posicao.getY());
        vetorObjetos.add(meninoCorrendo);
    }
    public void atualizaMenino()
    {
        for(AGSprite meninoCorrendo:vetorObjetos)
        {
            meninoCorrendo.vrPosition.setX(meninoCorrendo.vrPosition.getX() + 10);
            meninoCorrendo.fAngle+=5;
            if(meninoCorrendo.vrPosition.getX() > AGScreenManager.iScreenWidth + meninoCorrendo.getSpriteWidth()/2)
            {
                meninoCorrendo.bRecycled = true;
                meninoCorrendo.bVisible = false;
            }
        }

    }

    @Override
    public void restart() {

    }

    @Override
    public void stop() {

    }

    public void atualizaPlacar()
    {
        placar[0].setCurrentAnimation(numeroMenino / 10);
        placar[1].setCurrentAnimation(numeroMenino % 10);
    }

    @Override
    public void loop() {

//        cena.vrPosition.setX(cena.vrPosition.getX() + 5);
//
//
//        if(cena.vrPosition.getX() > AGScreenManager.iScreenWidth + cena.getSpriteWidth()/2)
//        {
//            cena.vrPosition.setX(-cena.getSpriteWidth()/2);
//        }222222
        if(AGInputManager.vrTouchEvents.screenClicked())
        {
            criaMenino(AGInputManager.vrTouchEvents.getLastPosition());
            numeroMenino ++;
        }
        if (AGInputManager.vrTouchEvents.backButtonClicked())
        {
            vrGameManager.setCurrentScene(0);
            return;
        }

        atualizaMenino();
        atualizaPlacar();
    }
}
