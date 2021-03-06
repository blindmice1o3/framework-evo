package com.evo.states;

import com.evo.Handler;
import com.evo.gfx.Animation;
import com.evo.gfx.Assets;

import java.awt.*;
import java.awt.event.KeyEvent;

public class IntroState implements IState {

    private Handler handler;

    private Animation waveAnimation;
    /*private int bodySizeIndex, bodyTextureIndex, jawsIndex, actionStateIndex, frameNumberIndex;*/
    //private Fish fishInstance;

    public IntroState(Handler handler) {
        this.handler = handler;

        waveAnimation = new Animation(120000000L, Assets.waveAnimationArray);
/*
        bodySizeIndex = 0;
        bodyTextureIndex = 0;
        jawsIndex = 0;
        actionStateIndex = 0;
        frameNumberIndex = 0;
*/
        //fishInstance = new Fish(handler);
    }

    @Override
    public void tick(long timeElapsed) {
        getInput();

        waveAnimation.tick(timeElapsed);
        /////////////////////
        //fishInstance.tick();
        /////////////////////
    }

    @Override
    public void getInput() {
        //a-button (will enter ChapterState).
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_COMMA)) {
            handler.getStateManager().pushIState(StateManager.State.CHAPTER, null);
        }
        //select (will enter MainMenuState).
        else if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_SHIFT)) {
            handler.getStateManager().pushIState(StateManager.State.MAIN_MENU, null);
        }
        //start (will enter PauseState).
        else if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_ENTER)) {
            handler.getStateManager().pushIState(StateManager.State.PAUSE, null);
        }

        switch (handler.getStateManager().getCurrentChapter()) {
            case ONE:
/*
                if (handler.getKeyManager().up) {
                    fishInstance.moveUp();
                }
                if (handler.getKeyManager().down) {
                    fishInstance.moveDown();
                }
                if (handler.getKeyManager().left) {
                    fishInstance.moveLeft();
                    ///////////////////////////////////////////////////////////
                    fishInstance.setDirectionFacing(Fish.MovementDirection.LEFT);
                    ///////////////////////////////////////////////////////////
                }
                if (handler.getKeyManager().right) {
                   fishInstance.moveRight();
                    ///////////////////////////////////////////////////////////
                   fishInstance.setDirectionFacing(Fish.MovementDirection.RIGHT);
                    ///////////////////////////////////////////////////////////
                }

                if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_Z)) {
                    int currentBodyTextureOrdinal = fishInstance.getFishStateManager().getCurrentBodyTexture().ordinal();
                    FishStateManager.BodyTexture[] bodyTexture = FishStateManager.BodyTexture.values();

                    if ((currentBodyTextureOrdinal+1) < bodyTexture.length) {
                        fishInstance.getFishStateManager().setCurrentBodyTexture(bodyTexture[currentBodyTextureOrdinal + 1]);
                    } else {
                        fishInstance.getFishStateManager().setCurrentBodyTexture(bodyTexture[0]);
                    }
                }

                if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_X)) {
                    int currentJawsOrdinal = fishInstance.getFishStateManager().getCurrentJaws().ordinal();
                    FishStateManager.Jaws[] jaws = FishStateManager.Jaws.values();

                    if ((currentJawsOrdinal+1) < jaws.length) {
                        fishInstance.getFishStateManager().setCurrentJaws(jaws[currentJawsOrdinal + 1]);
                    } else {
                        fishInstance.getFishStateManager().setCurrentJaws(jaws[0]);
                    }
                }

                if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_C)) {
                    int currentFinPectoralOrdinal = fishInstance.getFishStateManager().getCurrentFinPectoral().ordinal();
                    FishStateManager.FinPectoral[] finPectoral = FishStateManager.FinPectoral.values();

                    if ((currentFinPectoralOrdinal+1) < finPectoral.length) {
                        fishInstance.getFishStateManager().setCurrentFinPectoral(finPectoral[currentFinPectoralOrdinal + 1]);
                    } else {
                        fishInstance.getFishStateManager().setCurrentFinPectoral(finPectoral[0]);
                    }
                }
*/

                break;
            case TWO:
                //b-button
                if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_PERIOD)) {
                    handler.getStateManager().setCurrentChapter(StateManager.Chapter.ONE);
                    handler.getStateManager().popIState();
                }

                break;
            case THREE:
                //b-button
                if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_PERIOD)) {
                    handler.getStateManager().setCurrentChapter(StateManager.Chapter.TWO);
                    handler.getStateManager().popIState();
                }

                break;
            case FOUR:
                //b-button
                if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_PERIOD)) {
                    handler.getStateManager().setCurrentChapter(StateManager.Chapter.THREE);
                    handler.getStateManager().popIState();
                }

                break;
            case FIVE:
                //b-button
                if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_PERIOD)) {
                    handler.getStateManager().setCurrentChapter(StateManager.Chapter.FOUR);
                    handler.getStateManager().popIState();
                }

                break;
            default:
                break;
        }
    }

    private float opacity = 1.0f;
    @Override
    public void render(Graphics g) {
        //NullState.render(Graphics) ------> fills the screen with background color of Displayer's panel.
//        handler.getStateManager().getStatesStack().get(0).render(g);

        Graphics2D g2d = (Graphics2D)g;

        switch (handler.getStateManager().getCurrentChapter()) {
            case ONE:
                g2d.drawImage(Assets.chapter1Intro, 0, 0, handler.panelWidth, handler.panelHeight, null);

                // CHANGING OPACITY OF NEXT IMAGE
                opacity = 0.25f;
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
                ////////////////////////////////////////////////////////////////////////////////////
                g2d.drawImage(waveAnimation.getCurrentFrame(), 0, 0, handler.panelWidth, handler.panelHeight, null);
                ////////////////////////////////////////////////////////////////////////////////////
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));

                break;
            case TWO:
                g2d.drawImage(Assets.chapter2Intro, 0, 0, handler.panelWidth, handler.panelHeight, null);

                // CHANGING OPACITY OF NEXT IMAGE
                opacity = 0.25f;
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
                g2d.drawImage(Assets.chapter2Wave, 0, 0, handler.panelWidth, handler.panelHeight, null);

                break;
            case THREE:
                g2d.drawImage(Assets.chapter3Intro, 0, 0, handler.panelWidth, handler.panelHeight, null);

                // CHANGING OPACITY OF NEXT IMAGE
                opacity = 0.25f;
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
                g2d.drawImage(Assets.chapter3Wave, 0, 0, handler.panelWidth, handler.panelHeight, null);

                break;
            case FOUR:
                g2d.drawImage(Assets.chapter4Intro, 0, 0, handler.panelWidth, handler.panelHeight, null);

                // CHANGING OPACITY OF NEXT IMAGE
                opacity = 0.25f;
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
                g2d.drawImage(Assets.chapter4Wave, 0, 0, handler.panelWidth, handler.panelHeight, null);

                break;
            case FIVE:
                g2d.drawImage(Assets.chapter5Intro, 0, 0, handler.panelWidth, handler.panelHeight, null);

                // CHANGING OPACITY OF NEXT IMAGE
                opacity = 0.25f;
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
                g2d.drawImage(Assets.chapter5Wave, 0, 0, handler.panelWidth, handler.panelHeight, null);

                break;
            default:
                break;
        }

        //need to reset the opacity to 1.0f.
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));



        //fishInstance.render(g);



/*
        int xOffset = 0;
        int yOffset = 0;

        for (FishStateManager.BodySize bodySize : FishStateManager.BodySize.values()) {
            for (FishStateManager.BodyTexture bodyTexture : FishStateManager.BodyTexture.values()) {
                for (FishStateManager.Jaws jaws : FishStateManager.Jaws.values()) {
                    for (FishStateManager.ActionState actionState : FishStateManager.ActionState.values()) {

                        if (actionState.ordinal() < FishStateManager.ActionState.values().length-1) {
                            for (int index = 0; index < Assets.eatFrames[bodySize.ordinal()][bodyTexture.ordinal()]
                                    [jaws.ordinal()][actionState.ordinal()].length; index++) {
                                if (xOffset < handler.panelWidth - 16) {
                                    g.drawImage(Assets.eatFrames[bodySize.ordinal()]
                                            [bodyTexture.ordinal()]
                                            [jaws.ordinal()]
                                            [actionState.ordinal()]
                                            [index], xOffset, yOffset, null);

                                    xOffset += 16;

                                    if (xOffset >= handler.panelWidth - 16) {
                                        xOffset = 0;
                                        if (yOffset < handler.panelHeight) {
                                            yOffset += 16;
                                        }
                                    }
                                }
                            }
                            /////////////////////////////////////////////////////////////////////////////
                            for (int index = 0; index < Assets.biteFrames[bodySize.ordinal()][bodyTexture.ordinal()]
                                    [jaws.ordinal()][actionState.ordinal()].length; index++) {
                                if (xOffset < handler.panelWidth - 16) {
                                    g.drawImage(Assets.biteFrames[bodySize.ordinal()]
                                            [bodyTexture.ordinal()]
                                            [jaws.ordinal()]
                                            [actionState.ordinal()]
                                            [index], xOffset, yOffset, null);

                                    xOffset += 16;

                                    if (xOffset >= handler.panelWidth - 16) {
                                        xOffset = 0;
                                        if (yOffset < handler.panelHeight) {
                                            yOffset += 16;
                                        }
                                    }
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////
                            for (int index = 0; index < Assets.hurtFrames[bodySize.ordinal()][bodyTexture.ordinal()]
                                    [jaws.ordinal()][actionState.ordinal()].length; index++) {
                                if (xOffset < handler.panelWidth - 16) {
                                    g.drawImage(Assets.hurtFrames[bodySize.ordinal()]
                                            [bodyTexture.ordinal()]
                                            [jaws.ordinal()]
                                            [actionState.ordinal()]
                                            [index], xOffset, yOffset, null);

                                    xOffset += 16;

                                    if (xOffset >= handler.panelWidth - 16) {
                                        xOffset = 0;
                                        if (yOffset < handler.panelHeight) {
                                            yOffset += 16;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
*/





/*
        //@@@@@HEAD@@@@@

        g.drawImage(Assets.eatFrames[bodySizeIndex][bodyTextureIndex][jawsIndex][0][frameNumberIndex],
            0, 0, null);
        g.drawImage(Assets.biteFrames[bodySizeIndex][bodyTextureIndex][jawsIndex][1][frameNumberIndex],
                0, 16, null);
        if (frameNumberIndex != 2) {
            g.drawImage(Assets.hurtFrames[bodySizeIndex][bodyTextureIndex][jawsIndex][2][frameNumberIndex],
                    0, 32, null);
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        //@@@@@BODY@@@@@@@@@@@@@@@@@@@@@@@@DECREASE@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        //DECREASE-SLICK-ORIGINAL
        //tail: ORIGINAL
        int x = 0;
        int y = 60;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailOriginal[bodySizeIndex][FishStateManager.BodyTexture.SLICK.ordinal()]
                    [FishStateManager.FinPectoral.ORIGINAL.ordinal()]
                            [0][col],
                    x, y, null);

            if (col == 0) {
                x += 18;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: COELAFISH
        x = 0;
        y += 20;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailCoelafish[bodySizeIndex][FishStateManager.BodyTexture.SLICK.ordinal()]
                            [FishStateManager.FinPectoral.ORIGINAL.ordinal()]
                            [1][col],
                    x, y, null);

            if (col == 0) {
                x += 18;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: TERATISU
        x = 0;
        y += 20;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailTeratisu[bodySizeIndex][FishStateManager.BodyTexture.SLICK.ordinal()]
                            [FishStateManager.FinPectoral.ORIGINAL.ordinal()]
                            [2][col],
                    x, y, null);

            if (col == 0) {
                x += 18;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: ZINICHTHY
        x = 0;
        y += 20;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailZinichthy[bodySizeIndex][FishStateManager.BodyTexture.SLICK.ordinal()]
                            [FishStateManager.FinPectoral.ORIGINAL.ordinal()]
                            [3][col],
                    x, y, null);

            if (col == 0) {
                x += 18;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: KURASELACHE
        x = 0;
        y += 20;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailKuraselache[bodySizeIndex][FishStateManager.BodyTexture.SLICK.ordinal()]
                            [FishStateManager.FinPectoral.ORIGINAL.ordinal()]
                            [4][col],
                    x, y, null);

            if (col == 0) {
                x += 18;
            } else if (col == 1) {
                x += 25;
            }
        }


        //DECREASE-SCALY-ORIGINAL
        //tail: ORIGINAL
        x = 75;
        y = 60;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailOriginal[bodySizeIndex][FishStateManager.BodyTexture.SCALY.ordinal()]
                            [FishStateManager.FinPectoral.ORIGINAL.ordinal()]
                            [0][col],
                    x, y, null);

            if (col == 0) {
                x += 18;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: COELAFISH
        x = 75;
        y += 20;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailCoelafish[bodySizeIndex][FishStateManager.BodyTexture.SCALY.ordinal()]
                            [FishStateManager.FinPectoral.ORIGINAL.ordinal()]
                            [1][col],
                    x, y, null);

            if (col == 0) {
                x += 18;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: TERATISU
        x = 75;
        y += 20;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailTeratisu[bodySizeIndex][FishStateManager.BodyTexture.SCALY.ordinal()]
                            [FishStateManager.FinPectoral.ORIGINAL.ordinal()]
                            [2][col],
                    x, y, null);

            if (col == 0) {
                x += 18;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: ZINICHTHY
        x = 75;
        y += 20;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailZinichthy[bodySizeIndex][FishStateManager.BodyTexture.SCALY.ordinal()]
                            [FishStateManager.FinPectoral.ORIGINAL.ordinal()]
                            [3][col],
                    x, y, null);

            if (col == 0) {
                x += 18;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: KURASELACHE
        x = 75;
        y += 20;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailKuraselache[bodySizeIndex][FishStateManager.BodyTexture.SCALY.ordinal()]
                            [FishStateManager.FinPectoral.ORIGINAL.ordinal()]
                            [4][col],
                    x, y, null);

            if (col == 0) {
                x += 18;
            } else if (col == 1) {
                x += 25;
            }
        }



        //DECREASE-SHELL-ORIGINAL
        //tail: ORIGINAL
        x = 150;
        y = 60;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailOriginal[bodySizeIndex][FishStateManager.BodyTexture.SHELL.ordinal()]
                            [FishStateManager.FinPectoral.ORIGINAL.ordinal()]
                            [0][col],
                    x, y, null);

            if (col == 0) {
                x += 18;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: COELAFISH
        x = 150;
        y += 20;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailCoelafish[bodySizeIndex][FishStateManager.BodyTexture.SHELL.ordinal()]
                            [FishStateManager.FinPectoral.ORIGINAL.ordinal()]
                            [1][col],
                    x, y, null);

            if (col == 0) {
                x += 18;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: TERATISU
        x = 150;
        y += 20;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailTeratisu[bodySizeIndex][FishStateManager.BodyTexture.SHELL.ordinal()]
                            [FishStateManager.FinPectoral.ORIGINAL.ordinal()]
                            [2][col],
                    x, y, null);

            if (col == 0) {
                x += 18;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: ZINICHTHY
        x = 150;
        y += 20;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailZinichthy[bodySizeIndex][FishStateManager.BodyTexture.SHELL.ordinal()]
                            [FishStateManager.FinPectoral.ORIGINAL.ordinal()]
                            [3][col],
                    x, y, null);

            if (col == 0) {
                x += 18;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: KURASELACHE
        x = 150;
        y += 20;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailKuraselache[bodySizeIndex][FishStateManager.BodyTexture.SHELL.ordinal()]
                            [FishStateManager.FinPectoral.ORIGINAL.ordinal()]
                            [4][col],
                    x, y, null);

            if (col == 0) {
                x += 18;
            } else if (col == 1) {
                x += 25;
            }
        }


        /////////////////////////////////////////////////////////////////////////////////////////////////////////////


        //DECREASE-SLICK-COELAFISH
        //tail: ORIGINAL
        x = 0;
        y = 170;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailOriginal[bodySizeIndex][FishStateManager.BodyTexture.SLICK.ordinal()]
                            [FishStateManager.FinPectoral.COELAFISH.ordinal()]
                            [0][col],
                    x, y, null);

            if (col == 0) {
                x += 22;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: COELAFISH
        x = 0;
        y += 22;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailCoelafish[bodySizeIndex][FishStateManager.BodyTexture.SLICK.ordinal()]
                            [FishStateManager.FinPectoral.COELAFISH.ordinal()]
                            [1][col],
                    x, y, null);

            if (col == 0) {
                x += 22;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: TERATISU
        x = 0;
        y += 22;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailTeratisu[bodySizeIndex][FishStateManager.BodyTexture.SLICK.ordinal()]
                            [FishStateManager.FinPectoral.COELAFISH.ordinal()]
                            [2][col],
                    x, y, null);

            if (col == 0) {
                x += 22;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: ZINICHTHY
        x = 0;
        y += 22;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailZinichthy[bodySizeIndex][FishStateManager.BodyTexture.SLICK.ordinal()]
                            [FishStateManager.FinPectoral.COELAFISH.ordinal()]
                            [3][col],
                    x, y, null);

            if (col == 0) {
                x += 22;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: KURASELACHE
        x = 0;
        y += 22;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailKuraselache[bodySizeIndex][FishStateManager.BodyTexture.SLICK.ordinal()]
                            [FishStateManager.FinPectoral.COELAFISH.ordinal()]
                            [4][col],
                    x, y, null);

            if (col == 0) {
                x += 22;
            } else if (col == 1) {
                x += 25;
            }
        }


        //DECREASE-SCALY-COELAFISH
        //tail: ORIGINAL
        x = 75;
        y = 170;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailOriginal[bodySizeIndex][FishStateManager.BodyTexture.SCALY.ordinal()]
                            [FishStateManager.FinPectoral.COELAFISH.ordinal()]
                            [0][col],
                    x, y, null);

            if (col == 0) {
                x += 22;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: COELAFISH
        x = 75;
        y += 22;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailCoelafish[bodySizeIndex][FishStateManager.BodyTexture.SCALY.ordinal()]
                            [FishStateManager.FinPectoral.COELAFISH.ordinal()]
                            [1][col],
                    x, y, null);

            if (col == 0) {
                x += 22;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: TERATISU
        x = 75;
        y += 22;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailTeratisu[bodySizeIndex][FishStateManager.BodyTexture.SCALY.ordinal()]
                            [FishStateManager.FinPectoral.COELAFISH.ordinal()]
                            [2][col],
                    x, y, null);

            if (col == 0) {
                x += 22;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: ZINICHTHY
        x = 75;
        y += 22;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailZinichthy[bodySizeIndex][FishStateManager.BodyTexture.SCALY.ordinal()]
                            [FishStateManager.FinPectoral.COELAFISH.ordinal()]
                            [3][col],
                    x, y, null);

            if (col == 0) {
                x += 22;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: KURASELACHE
        x = 75;
        y += 22;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailKuraselache[bodySizeIndex][FishStateManager.BodyTexture.SCALY.ordinal()]
                            [FishStateManager.FinPectoral.COELAFISH.ordinal()]
                            [4][col],
                    x, y, null);

            if (col == 0) {
                x += 22;
            } else if (col == 1) {
                x += 25;
            }
        }



        //DECREASE-SHELL-COELAFISH
        //tail: ORIGINAL
        x = 150;
        y = 170;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailOriginal[bodySizeIndex][FishStateManager.BodyTexture.SHELL.ordinal()]
                            [FishStateManager.FinPectoral.COELAFISH.ordinal()]
                            [0][col],
                    x, y, null);

            if (col == 0) {
                x += 22;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: COELAFISH
        x = 150;
        y += 22;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailCoelafish[bodySizeIndex][FishStateManager.BodyTexture.SHELL.ordinal()]
                            [FishStateManager.FinPectoral.COELAFISH.ordinal()]
                            [1][col],
                    x, y, null);

            if (col == 0) {
                x += 22;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: TERATISU
        x = 150;
        y += 22;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailTeratisu[bodySizeIndex][FishStateManager.BodyTexture.SHELL.ordinal()]
                            [FishStateManager.FinPectoral.COELAFISH.ordinal()]
                            [2][col],
                    x, y, null);

            if (col == 0) {
                x += 22;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: ZINICHTHY
        x = 150;
        y += 22;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailZinichthy[bodySizeIndex][FishStateManager.BodyTexture.SHELL.ordinal()]
                            [FishStateManager.FinPectoral.COELAFISH.ordinal()]
                            [3][col],
                    x, y, null);

            if (col == 0) {
                x += 22;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: KURASELACHE
        x = 150;
        y += 22;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailKuraselache[bodySizeIndex][FishStateManager.BodyTexture.SHELL.ordinal()]
                            [FishStateManager.FinPectoral.COELAFISH.ordinal()]
                            [4][col],
                    x, y, null);

            if (col == 0) {
                x += 22;
            } else if (col == 1) {
                x += 25;
            }
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //DECREASE-SLICK-TACKLE
        //tail: ORIGINAL
        x = 0;
        y = 290;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailOriginal[bodySizeIndex][FishStateManager.BodyTexture.SLICK.ordinal()]
                            [FishStateManager.FinPectoral.TACKLE.ordinal()]
                            [0][col],
                    x, y, null);

            if (col == 0) {
                x += 19;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: COELAFISH
        x = 0;
        y += 17;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailCoelafish[bodySizeIndex][FishStateManager.BodyTexture.SLICK.ordinal()]
                            [FishStateManager.FinPectoral.TACKLE.ordinal()]
                            [1][col],
                    x, y, null);

            if (col == 0) {
                x += 19;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: TERATISU
        x = 0;
        y += 17;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailTeratisu[bodySizeIndex][FishStateManager.BodyTexture.SLICK.ordinal()]
                            [FishStateManager.FinPectoral.TACKLE.ordinal()]
                            [2][col],
                    x, y, null);

            if (col == 0) {
                x += 19;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: ZINICHTHY
        x = 0;
        y += 17;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailZinichthy[bodySizeIndex][FishStateManager.BodyTexture.SLICK.ordinal()]
                            [FishStateManager.FinPectoral.TACKLE.ordinal()]
                            [3][col],
                    x, y, null);

            if (col == 0) {
                x += 19;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: KURASELACHE
        x = 0;
        y += 17;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailKuraselache[bodySizeIndex][FishStateManager.BodyTexture.SLICK.ordinal()]
                            [FishStateManager.FinPectoral.TACKLE.ordinal()]
                            [4][col],
                    x, y, null);

            if (col == 0) {
                x += 19;
            } else if (col == 1) {
                x += 25;
            }
        }


        //DECREASE-SCALY-TACKLE
        //tail: ORIGINAL
        x = 75;
        y = 290;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailOriginal[bodySizeIndex][FishStateManager.BodyTexture.SCALY.ordinal()]
                            [FishStateManager.FinPectoral.TACKLE.ordinal()]
                            [0][col],
                    x, y, null);

            if (col == 0) {
                x += 19;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: COELAFISH
        x = 75;
        y += 17;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailCoelafish[bodySizeIndex][FishStateManager.BodyTexture.SCALY.ordinal()]
                            [FishStateManager.FinPectoral.TACKLE.ordinal()]
                            [1][col],
                    x, y, null);

            if (col == 0) {
                x += 19;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: TERATISU
        x = 75;
        y += 17;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailTeratisu[bodySizeIndex][FishStateManager.BodyTexture.SCALY.ordinal()]
                            [FishStateManager.FinPectoral.TACKLE.ordinal()]
                            [2][col],
                    x, y, null);

            if (col == 0) {
                x += 19;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: ZINICHTHY
        x = 75;
        y += 17;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailZinichthy[bodySizeIndex][FishStateManager.BodyTexture.SCALY.ordinal()]
                            [FishStateManager.FinPectoral.TACKLE.ordinal()]
                            [3][col],
                    x, y, null);

            if (col == 0) {
                x += 19;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: KURASELACHE
        x = 75;
        y += 17;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailKuraselache[bodySizeIndex][FishStateManager.BodyTexture.SCALY.ordinal()]
                            [FishStateManager.FinPectoral.TACKLE.ordinal()]
                            [4][col],
                    x, y, null);

            if (col == 0) {
                x += 19;
            } else if (col == 1) {
                x += 25;
            }
        }



        //DECREASE-SHELL-TACKLE
        //tail: ORIGINAL
        x = 150;
        y = 290;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailOriginal[bodySizeIndex][FishStateManager.BodyTexture.SHELL.ordinal()]
                            [FishStateManager.FinPectoral.TACKLE.ordinal()]
                            [0][col],
                    x, y, null);

            if (col == 0) {
                x += 19;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: COELAFISH
        x = 150;
        y += 17;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailCoelafish[bodySizeIndex][FishStateManager.BodyTexture.SHELL.ordinal()]
                            [FishStateManager.FinPectoral.TACKLE.ordinal()]
                            [1][col],
                    x, y, null);

            if (col == 0) {
                x += 19;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: TERATISU
        x = 150;
        y += 17;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailTeratisu[bodySizeIndex][FishStateManager.BodyTexture.SHELL.ordinal()]
                            [FishStateManager.FinPectoral.TACKLE.ordinal()]
                            [2][col],
                    x, y, null);

            if (col == 0) {
                x += 19;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: ZINICHTHY
        x = 150;
        y += 17;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailZinichthy[bodySizeIndex][FishStateManager.BodyTexture.SHELL.ordinal()]
                            [FishStateManager.FinPectoral.TACKLE.ordinal()]
                            [3][col],
                    x, y, null);

            if (col == 0) {
                x += 19;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: KURASELACHE
        x = 150;
        y += 17;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailKuraselache[bodySizeIndex][FishStateManager.BodyTexture.SHELL.ordinal()]
                            [FishStateManager.FinPectoral.TACKLE.ordinal()]
                            [4][col],
                    x, y, null);

            if (col == 0) {
                x += 19;
            } else if (col == 1) {
                x += 25;
            }
        }




        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        //@@@@@BODY@@@@@@@@@@@@@@@@@@@@@@@@INCREASE@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        //INCREASE-SLICK-ORIGINAL
        //tail: ORIGINAL
        x = 200;
        y = 60;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailOriginal[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SLICK.ordinal()]
                            [FishStateManager.FinPectoral.ORIGINAL.ordinal()]
                            [0][col],
                    x, y, null);

            if (col == 0) {
                x += 33;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: COELAFISH
        x = 200;
        y += 20;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailCoelafish[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SLICK.ordinal()]
                            [FishStateManager.FinPectoral.ORIGINAL.ordinal()]
                            [1][col],
                    x, y, null);

            if (col == 0) {
                x += 18;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: TERATISU
        x = 200;
        y += 20;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailTeratisu[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SLICK.ordinal()]
                            [FishStateManager.FinPectoral.ORIGINAL.ordinal()]
                            [2][col],
                    x, y, null);

            if (col == 0) {
                x += 18;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: ZINICHTHY
        x = 200;
        y += 20;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailZinichthy[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SLICK.ordinal()]
                            [FishStateManager.FinPectoral.ORIGINAL.ordinal()]
                            [3][col],
                    x, y, null);

            if (col == 0) {
                x += 18;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: KURASELACHE
        x = 200;
        y += 20;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailKuraselache[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SLICK.ordinal()]
                            [FishStateManager.FinPectoral.ORIGINAL.ordinal()]
                            [4][col],
                    x, y, null);

            if (col == 0) {
                x += 18;
            } else if (col == 1) {
                x += 25;
            }
        }


        //DECREASE-SCALY-ORIGINAL
        //tail: ORIGINAL
        x = 275;
        y = 60;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailOriginal[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SCALY.ordinal()]
                            [FishStateManager.FinPectoral.ORIGINAL.ordinal()]
                            [0][col],
                    x, y, null);

            if (col == 0) {
                x += 18;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: COELAFISH
        x = 275;
        y += 20;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailCoelafish[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SCALY.ordinal()]
                            [FishStateManager.FinPectoral.ORIGINAL.ordinal()]
                            [1][col],
                    x, y, null);

            if (col == 0) {
                x += 18;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: TERATISU
        x = 275;
        y += 20;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailTeratisu[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SCALY.ordinal()]
                            [FishStateManager.FinPectoral.ORIGINAL.ordinal()]
                            [2][col],
                    x, y, null);

            if (col == 0) {
                x += 18;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: ZINICHTHY
        x = 275;
        y += 20;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailZinichthy[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SCALY.ordinal()]
                            [FishStateManager.FinPectoral.ORIGINAL.ordinal()]
                            [3][col],
                    x, y, null);

            if (col == 0) {
                x += 18;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: KURASELACHE
        x = 275;
        y += 20;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailKuraselache[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SCALY.ordinal()]
                            [FishStateManager.FinPectoral.ORIGINAL.ordinal()]
                            [4][col],
                    x, y, null);

            if (col == 0) {
                x += 18;
            } else if (col == 1) {
                x += 25;
            }
        }



        //DECREASE-SHELL-ORIGINAL
        //tail: ORIGINAL
        x = 350;
        y = 60;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailOriginal[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SHELL.ordinal()]
                            [FishStateManager.FinPectoral.ORIGINAL.ordinal()]
                            [0][col],
                    x, y, null);

            if (col == 0) {
                x += 18;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: COELAFISH
        x = 350;
        y += 20;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailCoelafish[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SHELL.ordinal()]
                            [FishStateManager.FinPectoral.ORIGINAL.ordinal()]
                            [1][col],
                    x, y, null);

            if (col == 0) {
                x += 18;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: TERATISU
        x = 350;
        y += 20;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailTeratisu[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SHELL.ordinal()]
                            [FishStateManager.FinPectoral.ORIGINAL.ordinal()]
                            [2][col],
                    x, y, null);

            if (col == 0) {
                x += 18;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: ZINICHTHY
        x = 350;
        y += 20;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailZinichthy[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SHELL.ordinal()]
                            [FishStateManager.FinPectoral.ORIGINAL.ordinal()]
                            [3][col],
                    x, y, null);

            if (col == 0) {
                x += 18;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: KURASELACHE
        x = 350;
        y += 20;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailKuraselache[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SHELL.ordinal()]
                            [FishStateManager.FinPectoral.ORIGINAL.ordinal()]
                            [4][col],
                    x, y, null);

            if (col == 0) {
                x += 18;
            } else if (col == 1) {
                x += 25;
            }
        }


        /////////////////////////////////////////////////////////////////////////////////////////////////////////////


        //DECREASE-SLICK-COELAFISH
        //tail: ORIGINAL
        x = 200;
        y = 170;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailOriginal[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SLICK.ordinal()]
                            [FishStateManager.FinPectoral.COELAFISH.ordinal()]
                            [0][col],
                    x, y, null);

            if (col == 0) {
                x += 22;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: COELAFISH
        x = 200;
        y += 22;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailCoelafish[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SLICK.ordinal()]
                            [FishStateManager.FinPectoral.COELAFISH.ordinal()]
                            [1][col],
                    x, y, null);

            if (col == 0) {
                x += 22;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: TERATISU
        x = 200;
        y += 22;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailTeratisu[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SLICK.ordinal()]
                            [FishStateManager.FinPectoral.COELAFISH.ordinal()]
                            [2][col],
                    x, y, null);

            if (col == 0) {
                x += 22;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: ZINICHTHY
        x = 200;
        y += 22;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailZinichthy[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SLICK.ordinal()]
                            [FishStateManager.FinPectoral.COELAFISH.ordinal()]
                            [3][col],
                    x, y, null);

            if (col == 0) {
                x += 22;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: KURASELACHE
        x = 200;
        y += 22;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailKuraselache[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SLICK.ordinal()]
                            [FishStateManager.FinPectoral.COELAFISH.ordinal()]
                            [4][col],
                    x, y, null);

            if (col == 0) {
                x += 22;
            } else if (col == 1) {
                x += 25;
            }
        }


        //DECREASE-SCALY-COELAFISH
        //tail: ORIGINAL
        x = 275;
        y = 170;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailOriginal[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SCALY.ordinal()]
                            [FishStateManager.FinPectoral.COELAFISH.ordinal()]
                            [0][col],
                    x, y, null);

            if (col == 0) {
                x += 22;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: COELAFISH
        x = 275;
        y += 22;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailCoelafish[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SCALY.ordinal()]
                            [FishStateManager.FinPectoral.COELAFISH.ordinal()]
                            [1][col],
                    x, y, null);

            if (col == 0) {
                x += 22;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: TERATISU
        x = 275;
        y += 22;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailTeratisu[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SCALY.ordinal()]
                            [FishStateManager.FinPectoral.COELAFISH.ordinal()]
                            [2][col],
                    x, y, null);

            if (col == 0) {
                x += 22;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: ZINICHTHY
        x = 275;
        y += 22;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailZinichthy[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SCALY.ordinal()]
                            [FishStateManager.FinPectoral.COELAFISH.ordinal()]
                            [3][col],
                    x, y, null);

            if (col == 0) {
                x += 22;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: KURASELACHE
        x = 275;
        y += 22;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailKuraselache[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SCALY.ordinal()]
                            [FishStateManager.FinPectoral.COELAFISH.ordinal()]
                            [4][col],
                    x, y, null);

            if (col == 0) {
                x += 22;
            } else if (col == 1) {
                x += 25;
            }
        }



        //DECREASE-SHELL-COELAFISH
        //tail: ORIGINAL
        x = 350;
        y = 170;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailOriginal[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SHELL.ordinal()]
                            [FishStateManager.FinPectoral.COELAFISH.ordinal()]
                            [0][col],
                    x, y, null);

            if (col == 0) {
                x += 22;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: COELAFISH
        x = 350;
        y += 22;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailCoelafish[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SHELL.ordinal()]
                            [FishStateManager.FinPectoral.COELAFISH.ordinal()]
                            [1][col],
                    x, y, null);

            if (col == 0) {
                x += 22;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: TERATISU
        x = 350;
        y += 22;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailTeratisu[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SHELL.ordinal()]
                            [FishStateManager.FinPectoral.COELAFISH.ordinal()]
                            [2][col],
                    x, y, null);

            if (col == 0) {
                x += 22;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: ZINICHTHY
        x = 350;
        y += 22;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailZinichthy[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SHELL.ordinal()]
                            [FishStateManager.FinPectoral.COELAFISH.ordinal()]
                            [3][col],
                    x, y, null);

            if (col == 0) {
                x += 22;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: KURASELACHE
        x = 350;
        y += 22;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailKuraselache[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SHELL.ordinal()]
                            [FishStateManager.FinPectoral.COELAFISH.ordinal()]
                            [4][col],
                    x, y, null);

            if (col == 0) {
                x += 22;
            } else if (col == 1) {
                x += 25;
            }
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //DECREASE-SLICK-TACKLE
        //tail: ORIGINAL
        x = 200;
        y = 290;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailOriginal[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SLICK.ordinal()]
                            [FishStateManager.FinPectoral.TACKLE.ordinal()]
                            [0][col],
                    x, y, null);

            if (col == 0) {
                x += 19;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: COELAFISH
        x = 200;
        y += 17;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailCoelafish[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SLICK.ordinal()]
                            [FishStateManager.FinPectoral.TACKLE.ordinal()]
                            [1][col],
                    x, y, null);

            if (col == 0) {
                x += 19;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: TERATISU
        x = 200;
        y += 17;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailTeratisu[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SLICK.ordinal()]
                            [FishStateManager.FinPectoral.TACKLE.ordinal()]
                            [2][col],
                    x, y, null);

            if (col == 0) {
                x += 19;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: ZINICHTHY
        x = 200;
        y += 17;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailZinichthy[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SLICK.ordinal()]
                            [FishStateManager.FinPectoral.TACKLE.ordinal()]
                            [3][col],
                    x, y, null);

            if (col == 0) {
                x += 19;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: KURASELACHE
        x = 200;
        y += 17;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailKuraselache[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SLICK.ordinal()]
                            [FishStateManager.FinPectoral.TACKLE.ordinal()]
                            [4][col],
                    x, y, null);

            if (col == 0) {
                x += 19;
            } else if (col == 1) {
                x += 25;
            }
        }


        //DECREASE-SCALY-TACKLE
        //tail: ORIGINAL
        x = 275;
        y = 290;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailOriginal[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SCALY.ordinal()]
                            [FishStateManager.FinPectoral.TACKLE.ordinal()]
                            [0][col],
                    x, y, null);

            if (col == 0) {
                x += 19;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: COELAFISH
        x = 275;
        y += 17;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailCoelafish[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SCALY.ordinal()]
                            [FishStateManager.FinPectoral.TACKLE.ordinal()]
                            [1][col],
                    x, y, null);

            if (col == 0) {
                x += 19;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: TERATISU
        x = 275;
        y += 17;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailTeratisu[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SCALY.ordinal()]
                            [FishStateManager.FinPectoral.TACKLE.ordinal()]
                            [2][col],
                    x, y, null);

            if (col == 0) {
                x += 19;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: ZINICHTHY
        x = 275;
        y += 17;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailZinichthy[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SCALY.ordinal()]
                            [FishStateManager.FinPectoral.TACKLE.ordinal()]
                            [3][col],
                    x, y, null);

            if (col == 0) {
                x += 19;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: KURASELACHE
        x = 275;
        y += 17;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailKuraselache[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SCALY.ordinal()]
                            [FishStateManager.FinPectoral.TACKLE.ordinal()]
                            [4][col],
                    x, y, null);

            if (col == 0) {
                x += 19;
            } else if (col == 1) {
                x += 25;
            }
        }



        //DECREASE-SHELL-TACKLE
        //tail: ORIGINAL
        x = 350;
        y = 290;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailOriginal[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SHELL.ordinal()]
                            [FishStateManager.FinPectoral.TACKLE.ordinal()]
                            [0][col],
                    x, y, null);

            if (col == 0) {
                x += 19;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: COELAFISH
        x = 350;
        y += 17;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailCoelafish[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SHELL.ordinal()]
                            [FishStateManager.FinPectoral.TACKLE.ordinal()]
                            [1][col],
                    x, y, null);

            if (col == 0) {
                x += 19;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: TERATISU
        x = 350;
        y += 17;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailTeratisu[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SHELL.ordinal()]
                            [FishStateManager.FinPectoral.TACKLE.ordinal()]
                            [2][col],
                    x, y, null);

            if (col == 0) {
                x += 19;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: ZINICHTHY
        x = 350;
        y += 17;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailZinichthy[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SHELL.ordinal()]
                            [FishStateManager.FinPectoral.TACKLE.ordinal()]
                            [3][col],
                    x, y, null);

            if (col == 0) {
                x += 19;
            } else if (col == 1) {
                x += 25;
            }
        }

        //tail: KURASELACHE
        x = 350;
        y += 17;

        for (int col = 0; col < 3; col++) {
            g.drawImage(Assets.tailKuraselache[FishStateManager.BodySize.INCREASE.ordinal()]
                            [FishStateManager.BodyTexture.SHELL.ordinal()]
                            [FishStateManager.FinPectoral.TACKLE.ordinal()]
                            [4][col],
                    x, y, null);

            if (col == 0) {
                x += 19;
            } else if (col == 1) {
                x += 25;
            }
        }
*/
    }

    @Override
    public void enter(Object[] args) {

    }

    @Override
    public void exit() {

    }

    // GETTERS AND SETTERS
    //public Fish getPlayer() { return fishInstance; }

}