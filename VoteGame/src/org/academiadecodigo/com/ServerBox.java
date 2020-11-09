package org.academiadecodigo.com;

import org.academiadecodigo.simplegraphics.graphics.Text;

public class ServerBox {

    Text serverBox = new Text(200, 100, "");
    String text;

    public ServerBox() {
        showServerBox();
    }

    public void showServerBox() {
        serverBox.setFont(20);
        serverBox.draw();
    }

    public void setServerBox(String text) {
        text = text.replaceAll(" ", "  ");
        this.text = text;
        serverBox.setText(text);
    }

}
