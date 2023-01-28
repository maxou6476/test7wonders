package com.example._7wondersarchitect;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example._7wondersarchitect.jinx_aff.loadFXMLScene;


public class GameController implements Initializable{

    @FXML
    private ImageView imgPlayerTurn1,imgPlayerTurn2,imgPlayerTurn3,imgPlayerTurn4,imgPlayerTurn5,imgPlayerTurn6,imgPlayerTurn7;

    @FXML
    private ImageView imgPlayerTurn1u1,imgPlayerTurn2u1,imgPlayerTurn3u1,imgPlayerTurn4u1,imgPlayerTurn5u1,imgPlayerTurn6u1,imgPlayerTurn7u1;
    @FXML
    private ImageView imgPlayerTurn1u2,imgPlayerTurn2u2,imgPlayerTurn3u2,imgPlayerTurn4u2,imgPlayerTurn5u2,imgPlayerTurn6u2,imgPlayerTurn7u2;
    @FXML
    private ImageView imgPlayerTurn1u3,imgPlayerTurn2u3,imgPlayerTurn3u3,imgPlayerTurn4u3,imgPlayerTurn5u3,imgPlayerTurn6u3,imgPlayerTurn7u3;
    @FXML
    private ImageView imgPlayerTurn1u4,imgPlayerTurn2u4,imgPlayerTurn3u4,imgPlayerTurn4u4,imgPlayerTurn5u4,imgPlayerTurn6u4,imgPlayerTurn7u4;
    @FXML
    private ImageView imgPlayerTurn1u5,imgPlayerTurn2u5,imgPlayerTurn3u5,imgPlayerTurn4u5,imgPlayerTurn5u5,imgPlayerTurn6u5,imgPlayerTurn7u5;

    @FXML
    private ImageView imgCarteDeck,imgCarteJoueur1,imgCarteJoueur2,imgCarteJoueur3,imgCarteJoueur4,imgCarteJoueur5,imgCarteJoueur6,imgCarteJoueur7;
    @FXML
    private Text psuedoPlayer1,psuedoPlayer2,psuedoPlayer3,psuedoPlayer4,psuedoPlayer5,psuedoPlayer6,psuedoPlayer7;
    @FXML
    private Text nbBois, nbBouclier, nbBouclierC1,nbBouclierC2,nbBrique,nbCompas,nbEngrenage,nbOr,nbParchemin,nbPierre,nbPoint,nbPointChat,nbTablette,nbVerre;

    private boolean isPlaying = false;
    URL url = GameController.class.getResource("/music/legyptepointjpeg.mp3");
    Media media = new Media(url.toString());
    MediaPlayer mediaPlayerMusique = new MediaPlayer(media);


    void scaleUp(ImageView imageview){
        imageview.setScaleX(1.5);
        imageview.setScaleY(1.5);
    }
    void scaleDown(ImageView imageview){
        imageview.setScaleX(1);
        imageview.setScaleY(1);
    }

    public void showResources(){
        int bois=0, brique=0,Pierre=0,verre=0,parchemin=0,or=0,point=0,pointchat=0,engrenage=0,compas=0,tablette=0,bouclier1=0,boucliercorne=0,bouclier2cornes=0;
        Text[] nbres = {nbBois, nbBouclier, nbBouclierC1,nbBouclierC2,nbBrique,nbCompas,nbEngrenage,nbOr,nbParchemin,nbPierre,nbPoint,nbPointChat,nbTablette,nbVerre};
        for(int i=0;i<14;i++){
            nbres[i].setText("0");
        }
        if (jinx_aff.joueursList[jinx_aff.playerTurn] != null) {
            for (int i = 0; i < jinx_aff.joueursList[jinx_aff.playerTurn].handSize(); i++) {
                String card = jinx_aff.joueursList[jinx_aff.playerTurn].showcard().get(i).getNom();
                if (card == "Bois") {
                    bois++;
                    nbBois.setText(Integer.toString(bois));
                } else if (card == "Brique") {
                    brique++;
                    nbBrique.setText(Integer.toString(brique));
                } else if (card == "Pierre") {
                    Pierre++;
                    nbPierre.setText(Integer.toString(Pierre));
                } else if (card == "Verre") {
                    verre++;
                    nbVerre.setText(Integer.toString(verre));
                } else if (card == "Parchemin") {
                    parchemin++;
                    nbParchemin.setText(Integer.toString(parchemin));
                } else if (card == "Or") {
                    or++;
                    nbOr.setText(Integer.toString(or));
                } else if (card == "Point de victoire") {
                    point++;
                    nbPoint.setText(Integer.toString(point));
                } else if (card == "Point de victoire avec le pion chat") {
                    pointchat++;
                    nbPointChat.setText(Integer.toString(pointchat));
                } else if (card == "Engrenage") {
                    engrenage++;
                    nbEngrenage.setText(Integer.toString(engrenage));
                } else if (card == "Compas") {
                    compas++;
                    nbCompas.setText(Integer.toString(compas));
                } else if (card == "Tablette") {
                    tablette++;
                    nbTablette.setText(Integer.toString(tablette));
                } else if (card == "Bouclier") {
                    bouclier1++;
                    nbBouclier.setText(Integer.toString(bouclier1));
                } else if (card == "Bouclier avec 1 corne") {
                    boucliercorne++;
                    nbBouclierC1.setText(Integer.toString(boucliercorne));
                } else if (card == "Bouclier avec 2 cornes") {
                    bouclier2cornes++;
                    nbBouclierC2.setText(Integer.toString(bouclier2cornes));
                }
            }
        }
    }



    @FXML
    void passTour(ActionEvent event) {
        jinx_aff.playerTurn++;
        if(jinx_aff.playerTurn == jinx_aff.nbPlayer){
            jinx_aff.playerTurn = 0;
        }
        jinx_aff.joueursList[jinx_aff.playerTurn].getWonders().construction(jinx_aff.joueursList[jinx_aff.playerTurn]);
        changeImgMerv();
        changeImgCard();
        showResources();
        showUpgrade();
    }

    public void changeImgCard() {
        ImageView[] tabimgCarte = {imgCarteJoueur1,imgCarteJoueur2,imgCarteJoueur3,imgCarteJoueur4,imgCarteJoueur5,imgCarteJoueur6,imgCarteJoueur7};

        for(int i=jinx_aff.playerTurn;i<jinx_aff.nbPlayer+jinx_aff.playerTurn;i++) {

            if (jinx_aff.merveillesPlayer[i%jinx_aff.nbPlayer] == "alexandria")
            {
                if (Main.deckAlexandria.getNumberOfCards() == 0){
                    cardImage("none",tabimgCarte[(i - jinx_aff.playerTurn)]);
                }else {
                    cardImage(Main.deckAlexandria.getCards().get(0).getNom(), tabimgCarte[(i - jinx_aff.playerTurn)]);
                }
            } else if (jinx_aff.merveillesPlayer[i%jinx_aff.nbPlayer] == "artemis")
            {
                if (Main.deckArtemis.getNumberOfCards() == 0){
                    cardImage("none",tabimgCarte[(i - jinx_aff.playerTurn)]);
                }else {
                    cardImage(Main.deckArtemis.getCards().get(0).getNom(), tabimgCarte[(i - jinx_aff.playerTurn)]);
                }
            } else if (jinx_aff.merveillesPlayer[i%jinx_aff.nbPlayer] == "babylon")
            {
                if (Main.deckBabylon.getNumberOfCards() == 0){
                    cardImage("none",tabimgCarte[(i - jinx_aff.playerTurn)]);
                }else {
                    cardImage(Main.deckBabylon.getCards().get(0).getNom(), tabimgCarte[(i - jinx_aff.playerTurn)]);
                }
            } else if (jinx_aff.merveillesPlayer[i%jinx_aff.nbPlayer] == "gizeh")
            {
                if (Main.deckGizeh.getNumberOfCards() == 0){
                    cardImage("none",tabimgCarte[(i - jinx_aff.playerTurn)]);
                }else {
                    cardImage(Main.deckGizeh.getCards().get(0).getNom(), tabimgCarte[(i - jinx_aff.playerTurn)]);
                }
            } else if (jinx_aff.merveillesPlayer[i%jinx_aff.nbPlayer] == "hallicarnas")
            {
                if (Main.deckHalicarnass.getNumberOfCards() == 0){
                    cardImage("none",tabimgCarte[(i - jinx_aff.playerTurn)]);
                }else {
                    cardImage(Main.deckHalicarnass.getCards().get(0).getNom(), tabimgCarte[(i - jinx_aff.playerTurn)]);
                }
            } else if (jinx_aff.merveillesPlayer[i%jinx_aff.nbPlayer] == "rhodes")
            {
                if (Main.deckRhodes.getNumberOfCards() == 0){
                    cardImage("none",tabimgCarte[(i - jinx_aff.playerTurn)]);
                }else {
                    cardImage(Main.deckRhodes.getCards().get(0).getNom(), tabimgCarte[(i - jinx_aff.playerTurn)]);
                }
            } else if (jinx_aff.merveillesPlayer[i%jinx_aff.nbPlayer] == "zeus")
            {
                if (Main.deckZeus.getNumberOfCards() == 0){
                    cardImage("none",tabimgCarte[(i - jinx_aff.playerTurn)]);
                }else {
                    cardImage(Main.deckZeus.getCards().get(0).getNom(), tabimgCarte[(i - jinx_aff.playerTurn)]);
                }
            }
        }
    }

    public void cardImage(String card, ImageView cardimage){
        Image carteAllImage = new Image(new File("src/main/resources/images/cartes.png").toURI().toString());
        PixelReader reader = carteAllImage.getPixelReader();
        Image none = new WritableImage(reader,0,0,255,377);
        Image bois = new WritableImage(reader,0,377,255,377);
        Image Pierre = new WritableImage(reader,255,377,255,377);
        Image brique = new WritableImage(reader,510,377,255,377);
        Image parchemin = new WritableImage(reader,765,377,255,377);
        Image verre = new WritableImage(reader,1020,377,255,377);
        Image or = new WritableImage(reader,1275,377,255,377);
        Image pointchat = new WritableImage(reader,1530,377,255,377);
        Image point = new WritableImage(reader,1785,377,255,377);

        Image bouclier1 = new WritableImage(reader,0,754,255,377);
        Image boucliercorne = new WritableImage(reader,255,754,255,377);
        Image bouclier2cornes = new WritableImage(reader,510,754,255,377);
        Image compas = new WritableImage(reader,765,754,255,377);
        Image engrenage = new WritableImage(reader,1020,754,255,377);
        Image tablette = new WritableImage(reader,1275,754,255,377);

        Image unknowC = new WritableImage(reader,0,0,255,377);

        if(card == "Bois"){
            cardimage.setImage(bois);
        }else if(card == "Brique"){
            cardimage.setImage(brique);
        }else if(card == "Pierre"){
            cardimage.setImage(Pierre);
        }else if(card == "Verre"){
            cardimage.setImage(verre);
        }else if(card == "Parchemin"){
            cardimage.setImage(parchemin);
        }else if(card == "Or"){
            cardimage.setImage(or);
        }else if(card == "Point de victoire"){
            cardimage.setImage(point);
        }else if(card == "Point de victoire avec le pion chat"){
            cardimage.setImage(pointchat);
        }else if(card == "Engrenage"){
            cardimage.setImage(engrenage);
        }else if(card == "Compas"){
            cardimage.setImage(compas);
        }else if(card == "Tablette"){
            cardimage.setImage(tablette);
        }else if(card == "Bouclier"){
            cardimage.setImage(bouclier1);
        }else if(card == "Bouclier avec 1 corne"){
            cardimage.setImage(boucliercorne);
        }else if(card == "Bouclier avec 2 cornes"){
            cardimage.setImage(bouclier2cornes);
        }else if(card == "none"){
            cardimage.setImage(none);
        }
        imgCarteDeck.setImage(unknowC);
    }

        //3420 4438
        //0 570 1140 1710 2280 2850
        //0 634 1268 1902 2536 3170 3802


   public void podiumEnd() throws IOException {
        //jinx_aff.joueursList[jinx_aff.playerTurn].getWonders().construction(jinx_aff.joueursList[jinx_aff.playerTurn]);
        loadFXMLScene("podium.fxml");
    }


    public void showUpgrade(){
        ImageView[] tabimgPlayerTurnu1 = {imgPlayerTurn1u1,imgPlayerTurn2u1,imgPlayerTurn3u1,imgPlayerTurn4u1,imgPlayerTurn5u1,imgPlayerTurn6u1,imgPlayerTurn7u1};
        ImageView[] tabimgPlayerTurnu2 = {imgPlayerTurn1u2,imgPlayerTurn2u2,imgPlayerTurn3u2,imgPlayerTurn4u2,imgPlayerTurn5u2,imgPlayerTurn6u2,imgPlayerTurn7u2};
        ImageView[] tabimgPlayerTurnu3 = {imgPlayerTurn1u3,imgPlayerTurn2u3,imgPlayerTurn3u3,imgPlayerTurn4u3,imgPlayerTurn5u3,imgPlayerTurn6u3,imgPlayerTurn7u3};
        ImageView[] tabimgPlayerTurnu4 = {imgPlayerTurn1u4,imgPlayerTurn2u4,imgPlayerTurn3u4,imgPlayerTurn4u4,imgPlayerTurn5u4,imgPlayerTurn6u4,imgPlayerTurn7u4};
        ImageView[] tabimgPlayerTurnu5 = {imgPlayerTurn1u5,imgPlayerTurn2u5,imgPlayerTurn3u5,imgPlayerTurn4u5,imgPlayerTurn5u5,imgPlayerTurn6u5,imgPlayerTurn7u5};

        Image carteAllImage = new Image(new File("src/main/resources/images/wonders.png").toURI().toString());
        PixelReader reader = carteAllImage.getPixelReader();
        Image alexandriaImageu1 = new WritableImage(reader,570,1902,570,634);
        Image alexandriaImageu2 = new WritableImage(reader,1140,1902,570,634);
        Image alexandriaImageu3 = new WritableImage(reader,1710,1902,570,634);
        Image alexandriaImageu4 = new WritableImage(reader,2280,1902,570,634);
        Image alexandriaImageu5 = new WritableImage(reader,2850,1902,570,634);

        Image artemisimageu1 = new WritableImage(reader,570,3802,570,634);
        Image artemisimageu2 = new WritableImage(reader,1140,3802,570,634);
        Image artemisimageu3 = new WritableImage(reader,1710,3802,570,634);
        Image artemisimageu4 = new WritableImage(reader,2280,3802,570,634);
        Image artemisimageu5 = new WritableImage(reader,2850,3802,570,634);

        Image babylonimageu1 = new WritableImage(reader,570,634,570,634);
        Image babylonimageu2 = new WritableImage(reader,1140,634,570,634);
        Image babylonimageu3 = new WritableImage(reader,1710,634,570,634);
        Image babylonimageu4 = new WritableImage(reader,2280,634,570,634);
        Image babylonimageu5 = new WritableImage(reader,2850,634,570,634);

        Image gizehimageu1 = new WritableImage(reader,570,2536,570,634);
        Image gizehimageu2 = new WritableImage(reader,1140,2536,570,634);
        Image gizehimageu3 = new WritableImage(reader,1710,2536,570,634);
        Image gizehimageu4 = new WritableImage(reader,2280,2536,570,634);
        Image gizehimageu5 = new WritableImage(reader,2850,2536,570,634);

        Image hallicarnasimageu1 = new WritableImage(reader,570,1268,570,634);
        Image hallicarnasimageu2 = new WritableImage(reader,1140,1268,570,634);
        Image hallicarnasimageu3 = new WritableImage(reader,1710,1268,570,634);
        Image hallicarnasimageu4 = new WritableImage(reader,2280,1268,570,634);
        Image hallicarnasimageu5 = new WritableImage(reader,2850,1268,570,634);

        Image rhodesimageu1 = new WritableImage(reader,570,0,570,634);
        Image rhodesimageu2 = new WritableImage(reader,1140,0,570,634);
        Image rhodesimageu3 = new WritableImage(reader,1710,0,570,634);
        Image rhodesimageu4 = new WritableImage(reader,2280,0,570,634);
        Image rhodesimageu5 = new WritableImage(reader,2850,0,570,634);

        Image zeusimageu1 = new WritableImage(reader,570,3170,570,634);
        Image zeusimageu2 = new WritableImage(reader,1140,3170,570,634);
        Image zeusimageu3 = new WritableImage(reader,1710,3170,570,634);
        Image zeusimageu4 = new WritableImage(reader,2280,3170,570,634);
        Image zeusimageu5 = new WritableImage(reader,2850,3170,570,634);

        for(int i=0;i<7;i++){
            tabimgPlayerTurnu1[i].setVisible(false);
            tabimgPlayerTurnu2[i].setVisible(false);
            tabimgPlayerTurnu3[i].setVisible(false);
            tabimgPlayerTurnu4[i].setVisible(false);
            tabimgPlayerTurnu5[i].setVisible(false);
        }
            tabimgPlayerTurnu1[jinx_aff.playerTurn].setVisible(true);
            tabimgPlayerTurnu2[jinx_aff.playerTurn].setVisible(true);
            tabimgPlayerTurnu3[jinx_aff.playerTurn].setVisible(true);
            tabimgPlayerTurnu4[jinx_aff.playerTurn].setVisible(true);
            tabimgPlayerTurnu5[jinx_aff.playerTurn].setVisible(true);
            int selecttabJwonders = jinx_aff.playerTurn;
            int selectimagetabJ = (jinx_aff.nbPlayer - jinx_aff.playerTurn)%jinx_aff.nbPlayer;


        if(jinx_aff.joueursList[jinx_aff.playerTurn].getWonders().getUpgrade() >= 1){

            if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Alexandrie"){
                tabimgPlayerTurnu1[selecttabJwonders].setImage(alexandriaImageu1);
            }else if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Artemis"){
                tabimgPlayerTurnu1[selecttabJwonders].setImage(artemisimageu1);
            }else if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Babylon"){
                tabimgPlayerTurnu1[selecttabJwonders].setImage(babylonimageu1);
            }else if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Gizeh"){
                tabimgPlayerTurnu1[selecttabJwonders].setImage(gizehimageu1);
            }else if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Halicarnasse"){
                tabimgPlayerTurnu1[selecttabJwonders].setImage(hallicarnasimageu1);
            }else if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Rhodes"){
                tabimgPlayerTurnu1[selecttabJwonders].setImage(rhodesimageu1);
            }else if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Zeus"){
                tabimgPlayerTurnu1[selecttabJwonders].setImage(zeusimageu1);
            }
        }
        if(jinx_aff.joueursList[jinx_aff.playerTurn].getWonders().getUpgrade() >= 2){
            if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Alexandrie"){
                tabimgPlayerTurnu2[selecttabJwonders].setImage(alexandriaImageu2);
            }else if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Artemis"){
                tabimgPlayerTurnu2[selecttabJwonders].setImage(artemisimageu2);
            }else if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Babylon"){
                tabimgPlayerTurnu2[selecttabJwonders].setImage(babylonimageu2);
            }else if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Gizeh"){
                tabimgPlayerTurnu2[selecttabJwonders].setImage(gizehimageu2);
            }else if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Halicarnasse"){
                tabimgPlayerTurnu2[selecttabJwonders].setImage(hallicarnasimageu2);
            }else if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Rhodes"){
                tabimgPlayerTurnu2[selecttabJwonders].setImage(rhodesimageu2);
            }else if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Zeus"){
                tabimgPlayerTurnu2[selecttabJwonders].setImage(zeusimageu2);
            }
        }
        if(jinx_aff.joueursList[jinx_aff.playerTurn].getWonders().getUpgrade() >= 3){
            if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Alexandrie"){
                tabimgPlayerTurnu3[selecttabJwonders].setImage(alexandriaImageu3);
            }else if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Artemis"){
                tabimgPlayerTurnu3[selecttabJwonders].setImage(artemisimageu3);
            }else if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Babylon"){
                tabimgPlayerTurnu3[selecttabJwonders].setImage(babylonimageu3);
            }else if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Gizeh"){
                tabimgPlayerTurnu3[selecttabJwonders].setImage(gizehimageu3);
            }else if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Halicarnasse"){
                tabimgPlayerTurnu3[selecttabJwonders].setImage(hallicarnasimageu3);
            }else if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Rhodes"){
                tabimgPlayerTurnu3[selecttabJwonders].setImage(rhodesimageu3);
            }else if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Zeus"){
                tabimgPlayerTurnu3[selecttabJwonders].setImage(zeusimageu3);
            }
        }
        if(jinx_aff.joueursList[jinx_aff.playerTurn].getWonders().getUpgrade() >= 4){
            if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Alexandrie"){
                tabimgPlayerTurnu4[selecttabJwonders].setImage(alexandriaImageu4);
            }else if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Artemis"){
                tabimgPlayerTurnu4[selecttabJwonders].setImage(artemisimageu4);
            }else if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Babylon"){
                tabimgPlayerTurnu4[selecttabJwonders].setImage(babylonimageu4);
            }else if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Gizeh"){
                tabimgPlayerTurnu4[selecttabJwonders].setImage(gizehimageu4);
            }else if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Halicarnasse"){
                tabimgPlayerTurnu4[selecttabJwonders].setImage(hallicarnasimageu4);
            }else if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Rhodes"){
                tabimgPlayerTurnu4[selecttabJwonders].setImage(rhodesimageu4);
            }else if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Zeus"){
                tabimgPlayerTurnu4[selecttabJwonders].setImage(zeusimageu4);
            }
        }
        if(jinx_aff.joueursList[jinx_aff.playerTurn].getWonders().getUpgrade() >= 5){
            if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Alexandrie"){
                tabimgPlayerTurnu5[selecttabJwonders].setImage(alexandriaImageu5);
            }else if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Artemis"){
                tabimgPlayerTurnu5[selecttabJwonders].setImage(artemisimageu5);
            }else if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Babylon"){
                tabimgPlayerTurnu5[selecttabJwonders].setImage(babylonimageu5);
            }else if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Gizeh"){
                tabimgPlayerTurnu5[selecttabJwonders].setImage(gizehimageu5);
            }else if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Halicarnasse"){
                tabimgPlayerTurnu5[selecttabJwonders].setImage(hallicarnasimageu5);
            }else if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Rhodes"){
                tabimgPlayerTurnu5[selecttabJwonders].setImage(rhodesimageu5);
            }else if(jinx_aff.joueursList[selectimagetabJ].getWonders().getnomM() == "Zeus"){
                tabimgPlayerTurnu5[selecttabJwonders].setImage(zeusimageu5);
            }
        }
    }

    public void changeImgMerv(){
        Text[] tabpsuedoPlayer = {psuedoPlayer1,psuedoPlayer2,psuedoPlayer3,psuedoPlayer4,psuedoPlayer5,psuedoPlayer6,psuedoPlayer7};
        ImageView[] tabimgPlayerTurn = {imgPlayerTurn1,imgPlayerTurn2,imgPlayerTurn3,imgPlayerTurn4,imgPlayerTurn5,imgPlayerTurn6,imgPlayerTurn7};

        Image carteAllImage = new Image(new File("src/main/resources/images/wonders.png").toURI().toString());
        PixelReader reader = carteAllImage.getPixelReader();
        Image alexandriaImage = new WritableImage(reader,0,1902,570,634);
        Image artemisimage = new WritableImage(reader,0,3802,570,634);
        Image babylonimage = new WritableImage(reader,0,634,570,634);
        Image gizehimage = new WritableImage(reader,0,2536,570,634);
        Image hallicarnasimage = new WritableImage(reader,0,1268,570,634);
        Image rhodesimage = new WritableImage(reader,0,0,570,634);
        Image zeusimage = new WritableImage(reader,0,3170,570,634);


        for(int i=jinx_aff.playerTurn;i<jinx_aff.nbPlayer+jinx_aff.playerTurn;i++) {
            if (jinx_aff.merveillesPlayer[(i) - jinx_aff.playerTurn] == "alexandria") {
                tabimgPlayerTurn[(i) % jinx_aff.nbPlayer].setImage(alexandriaImage);
            } else if (jinx_aff.merveillesPlayer[(i) - jinx_aff.playerTurn] == "artemis") {
                tabimgPlayerTurn[(i) % jinx_aff.nbPlayer].setImage(artemisimage);
            } else if (jinx_aff.merveillesPlayer[(i) - jinx_aff.playerTurn] == "babylon") {
                tabimgPlayerTurn[(i) % jinx_aff.nbPlayer].setImage(babylonimage);
            } else if (jinx_aff.merveillesPlayer[(i) - jinx_aff.playerTurn] == "gizeh") {
                tabimgPlayerTurn[(i) % jinx_aff.nbPlayer].setImage(gizehimage);
            } else if (jinx_aff.merveillesPlayer[(i) - jinx_aff.playerTurn] == "hallicarnas") {
                tabimgPlayerTurn[(i) % jinx_aff.nbPlayer].setImage(hallicarnasimage);
            } else if (jinx_aff.merveillesPlayer[(i) - jinx_aff.playerTurn] == "rhodes") {
                tabimgPlayerTurn[(i) % jinx_aff.nbPlayer].setImage(rhodesimage);
            } else if (jinx_aff.merveillesPlayer[(i) - jinx_aff.playerTurn] == "zeus") {
                tabimgPlayerTurn[(i) % jinx_aff.nbPlayer].setImage(zeusimage);
            } else {
                tabimgPlayerTurn[(i) % jinx_aff.nbPlayer].setImage(zeusimage);
            }
            tabpsuedoPlayer[i % jinx_aff.nbPlayer].setText(jinx_aff.pseudoPlayer[i % jinx_aff.nbPlayer]);
        }
        
    }
    @FXML
    void musicPlay(ActionEvent event){
        if (isPlaying == false) {
            mediaPlayerMusique.play();
            isPlaying = true;
        } else if (isPlaying==true) {
            mediaPlayerMusique.pause();
            isPlaying = false;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        changeImgMerv();
        changeImgCard();

        ImageView[] tabimgPlayerTurn = {imgPlayerTurn1,imgPlayerTurn2,imgPlayerTurn3,imgPlayerTurn4,imgPlayerTurn5,imgPlayerTurn6,imgPlayerTurn7};

        ImageView[] tabimgPlayerTurnu1 = {imgPlayerTurn1u1,imgPlayerTurn2u1,imgPlayerTurn3u1,imgPlayerTurn4u1,imgPlayerTurn5u1,imgPlayerTurn6u1,imgPlayerTurn7u1};
        ImageView[] tabimgPlayerTurnu2 = {imgPlayerTurn1u2,imgPlayerTurn2u2,imgPlayerTurn3u2,imgPlayerTurn4u2,imgPlayerTurn5u2,imgPlayerTurn6u2,imgPlayerTurn7u2};
        ImageView[] tabimgPlayerTurnu3 = {imgPlayerTurn1u3,imgPlayerTurn2u3,imgPlayerTurn3u3,imgPlayerTurn4u3,imgPlayerTurn5u3,imgPlayerTurn6u3,imgPlayerTurn7u3};
        ImageView[] tabimgPlayerTurnu4 = {imgPlayerTurn1u4,imgPlayerTurn2u4,imgPlayerTurn3u4,imgPlayerTurn4u4,imgPlayerTurn5u4,imgPlayerTurn6u4,imgPlayerTurn7u4};
        ImageView[] tabimgPlayerTurnu5 = {imgPlayerTurn1u5,imgPlayerTurn2u5,imgPlayerTurn3u5,imgPlayerTurn4u5,imgPlayerTurn5u5,imgPlayerTurn6u5,imgPlayerTurn7u5};

        Text[] tabpsuedoPlayer = {psuedoPlayer1,psuedoPlayer2,psuedoPlayer3,psuedoPlayer4,psuedoPlayer5,psuedoPlayer6,psuedoPlayer7};
        int[] tabWaitingP = {550,450,350,250,150,50,0};
        int[] tabWaitingPpsuedo = {510,410,310,210,110,10,0};

        ImageView[] tabimgCarte = {imgCarteJoueur1,imgCarteJoueur2,imgCarteJoueur3,imgCarteJoueur4,imgCarteJoueur5,imgCarteJoueur6,imgCarteJoueur7};



        //Placement des merveilles des joueurs
        for(int i=1;i<jinx_aff.nbPlayer;i++) {
            tabimgPlayerTurn[i].setLayoutY(50);
            tabimgPlayerTurn[i].setLayoutX(tabWaitingP[jinx_aff.nbPlayer - 2] + 200 * (i-1));
            tabpsuedoPlayer[i].setLayoutY(180);
            tabpsuedoPlayer[i].setLayoutX(tabWaitingPpsuedo[jinx_aff.nbPlayer - 2] + 200 * (i-1));

            tabimgPlayerTurnu1[i].setLayoutY(400);
            tabimgPlayerTurnu1[i].setLayoutX(425);
            tabimgPlayerTurnu1[i].setFitWidth(350);
            tabimgPlayerTurnu1[i].setFitHeight(350);

            tabimgPlayerTurnu2[i].setLayoutY(400);
            tabimgPlayerTurnu2[i].setLayoutX(425);
            tabimgPlayerTurnu2[i].setFitWidth(350);
            tabimgPlayerTurnu2[i].setFitHeight(350);

            tabimgPlayerTurnu3[i].setLayoutY(400);
            tabimgPlayerTurnu3[i].setLayoutX(425);
            tabimgPlayerTurnu3[i].setFitWidth(350);
            tabimgPlayerTurnu3[i].setFitHeight(350);

            tabimgPlayerTurnu4[i].setLayoutY(400);
            tabimgPlayerTurnu4[i].setLayoutX(425);
            tabimgPlayerTurnu4[i].setFitWidth(350);
            tabimgPlayerTurnu4[i].setFitHeight(350);

            tabimgPlayerTurnu5[i].setLayoutY(400);
            tabimgPlayerTurnu5[i].setLayoutX(425);
            tabimgPlayerTurnu5[i].setFitWidth(350);
            tabimgPlayerTurnu5[i].setFitHeight(350);
        }
        //placement des cartes des joueurs (pas le deck)
        for (int i=1;i<jinx_aff.nbPlayer-1;i++)
        {
                tabimgCarte[i].setLayoutY(75);
                tabimgCarte[i].setLayoutX(tabWaitingP[jinx_aff.nbPlayer - 2] + 200 * (i-1) + 50);
        }
        tabimgCarte[jinx_aff.nbPlayer-1].setLayoutY(505);
        tabimgCarte[jinx_aff.nbPlayer-1].setLayoutX(852);
        tabimgCarte[jinx_aff.nbPlayer-1].setFitWidth(110);
        tabimgCarte[jinx_aff.nbPlayer-1].setFitHeight(140);


        tabimgPlayerTurnu1[0].setLayoutY(400);
        tabimgPlayerTurnu1[0].setLayoutX(425);
        tabimgPlayerTurnu1[0].setFitWidth(350);
        tabimgPlayerTurnu1[0].setFitHeight(350);

        tabimgPlayerTurnu2[0].setLayoutY(400);
        tabimgPlayerTurnu2[0].setLayoutX(425);
        tabimgPlayerTurnu2[0].setFitWidth(350);
        tabimgPlayerTurnu2[0].setFitHeight(350);

        tabimgPlayerTurnu3[0].setLayoutY(400);
        tabimgPlayerTurnu3[0].setLayoutX(425);
        tabimgPlayerTurnu3[0].setFitWidth(350);
        tabimgPlayerTurnu3[0].setFitHeight(350);

        tabimgPlayerTurnu4[0].setLayoutY(400);
        tabimgPlayerTurnu4[0].setLayoutX(425);
        tabimgPlayerTurnu4[0].setFitWidth(350);
        tabimgPlayerTurnu4[0].setFitHeight(350);

        tabimgPlayerTurnu5[0].setLayoutY(400);
        tabimgPlayerTurnu5[0].setLayoutX(425);
        tabimgPlayerTurnu5[0].setFitWidth(350);
        tabimgPlayerTurnu5[0].setFitHeight(350);

            //interaction avec le deck
            imgCarteDeck.setOnMouseEntered(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent mouseEvent) {
                    scaleUp(imgCarteDeck);
                }
            });

            imgCarteDeck.setOnMouseExited(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent mouseEvent) {
                    scaleDown(imgCarteDeck);
                }
            });
            imgCarteDeck.setOnMouseClicked(new EventHandler<MouseEvent>(){
                public void handle(MouseEvent mouseEvent) {
                    if(Main.deckCenter.getNumberOfCards() != 0) {
                        jinx_aff.joueursList[jinx_aff.playerTurn].addCard(Main.deckCenter.getCards().get(0));
                        Main.deckCenter.drawCard();
                        changeImgCard();
                        showResources();
                    }else{
                        System.out.println("plus de deck dans la pioche");
                    }
                }
            });

            //interaction carte joueur de gauche
            tabimgCarte[jinx_aff.playerTurn].setOnMouseEntered(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent mouseEvent) {
                    scaleUp(tabimgCarte[0]);
                }
            });
            tabimgCarte[jinx_aff.playerTurn].setOnMouseExited(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent mouseEvent) {
                    scaleDown(tabimgCarte[0]);
                }
            });
            tabimgCarte[jinx_aff.playerTurn].setOnMouseClicked(new EventHandler<MouseEvent>(){
                public void handle(MouseEvent mouseEvent) {
                    if(jinx_aff.joueursList[jinx_aff.playerTurn].getDeck().getNumberOfCards() != 0) {
                        jinx_aff.joueursList[jinx_aff.playerTurn].addCard(jinx_aff.joueursList[jinx_aff.playerTurn].getDeck().getCards().get(0));
                        jinx_aff.joueursList[jinx_aff.playerTurn].getDeck().drawCard();
                        changeImgCard();
                        showResources();
                    }else{
                        System.out.println("plus de carte dans votre deck");
                    }
                }
            });

            //------------------interaction carte joueur de droite--------------------------
            tabimgCarte[jinx_aff.nbPlayer-1].setOnMouseEntered(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent mouseEvent) {
                    scaleUp(tabimgCarte[jinx_aff.nbPlayer-1]);
                }
            });

            tabimgCarte[jinx_aff.nbPlayer-1].setOnMouseExited(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent mouseEvent) {
                    scaleDown(tabimgCarte[jinx_aff.nbPlayer-1]);
                }
            });


            tabimgCarte[jinx_aff.nbPlayer-1].setOnMouseClicked(new EventHandler<MouseEvent>(){
                public void handle(MouseEvent mouseEvent) {
                    if(jinx_aff.joueursList[jinx_aff.nbPlayer-1].getDeck().getNumberOfCards() != 0){
                        jinx_aff.joueursList[jinx_aff.playerTurn].addCard(jinx_aff.joueursList[(jinx_aff.playerTurn + jinx_aff.nbPlayer-1) % jinx_aff.nbPlayer].getDeck().getCards().get(0));
                        jinx_aff.joueursList[(jinx_aff.playerTurn + jinx_aff.nbPlayer-1) % jinx_aff.nbPlayer].getDeck().drawCard();
                        changeImgCard();
                        showResources();
                    }else{
                        System.out.println("plus de carte dans le deck de ce joueur");
                    }

                }
            });
    }
}