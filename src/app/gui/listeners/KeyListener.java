package app.gui.listeners;

import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyListener {
    private static volatile boolean shiftPressed = false;

    public static boolean isShiftPressed() {
        synchronized (KeyListener.class) {
            return shiftPressed;
        }
    }

    public static void init() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(ke -> {
            synchronized (KeyListener.class) {
                switch (ke.getID()) {
                    case KeyEvent.KEY_PRESSED:
                        if (ke.getKeyCode() == KeyEvent.VK_SHIFT) {
                            shiftPressed = true;
                        }
                        break;

                    case KeyEvent.KEY_RELEASED:
                        if (ke.getKeyCode() == KeyEvent.VK_SHIFT) {
                            shiftPressed = false;
                        }
                        break;
                }
                return false;
            }
        });
    }
}
