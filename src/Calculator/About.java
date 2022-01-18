package Calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class About {

    @FXML
    void onLinkClick(ActionEvent event) throws URISyntaxException, IOException {

        Desktop.getDesktop().browse(new URI("https://www.github.com/rytnix"));
    }

}
