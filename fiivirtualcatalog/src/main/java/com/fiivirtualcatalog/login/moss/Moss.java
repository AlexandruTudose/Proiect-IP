package com.fiivirtualcatalog.login.moss;

import java.io.File;
import java.net.URL;
import java.util.Collection;

import it.zielke.moji.MossException;
import org.apache.commons.io.FileUtils;
import it.zielke.moji.SocketClient;

/**
 * Created by Alex on 03.05.2017.
 */
public class Moss {
    private static Moss ourInstance = new Moss();

    public static Moss getInstance() {
        return ourInstance;
    }

    private Moss() {
    }

    public String runMoss(String path1,String path2,String language) throws Exception {
        //sursele studentilor
        Collection<File> files = FileUtils.listFiles(new File(
                path1), new String[] { language }, true);

        //fisiere de baza date de prof
        Collection<File> baseFiles = FileUtils.listFiles(new File(
                path2), new String[] { language }, true);

        SocketClient socketClient = new SocketClient();

        //User Id-ul meu
        socketClient.setUserID("70543835");
        //socketClient.setOpt...

        //limbajul de programare dupa care comparam
        socketClient.setLanguage(language);
        socketClient.run();
        for (File f : baseFiles) {
            socketClient.uploadBaseFile(f);
        }
        for (File f : files) {
            socketClient.uploadFile(f);
        }
        //verific fisierele
        socketClient.sendQuery();

        //primesc link-ul cu rezultatele
        URL results = socketClient.getResultURL();
        return  results.toString();
    }

}
