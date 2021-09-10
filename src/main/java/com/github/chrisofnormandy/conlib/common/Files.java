package com.github.chrisofnormandy.conlib.common;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Path;

import com.github.chrisofnormandy.conlib.Main;

import net.minecraftforge.fml.loading.FMLPaths;

public class Files {
    /**
     * 
     * @param path
     * @param name
     * @param data
     * @param ext
     */
    public static final void write(String path, String name, String data, String ext) {
        Path p = FMLPaths.GAMEDIR.get().resolve(path);
        final File dir = p.toFile();

        if (!dir.exists())
            dir.mkdirs();

        try {
            PrintWriter out = new PrintWriter(path + "/" + name + ext);
            out.write(data);
            out.close();
        } catch (Exception err) {
            Main.LOG.error("Failed to write to file: " + path + "/" + name + ext);
            Main.LOG.error(err);
        }
    }

    /**
     * 
     * @param path
     * @param name
     * @param data
     * @param ext
     */
    public static final void writeToSave(String path, String name, String data, String ext) {
        File[] saves = new File(FMLPaths.GAMEDIR.get().resolve("saves").toString()).listFiles(File::isDirectory);

        for (File file : saves) {
            Path p = FMLPaths.GAMEDIR.get().resolve(file.toString() + "/" + path);
            final File dir = p.toFile();

            if (!dir.exists())
                dir.mkdirs();

            try {
                PrintWriter out = new PrintWriter(p.toString() + "/" + name + ext);
                out.write(data);
                out.close();
            } catch (Exception err) {
                Main.LOG.error("Failed to write to file: " + p.toString() + "/" + name + ext);
                Main.LOG.error(err);
            }
        }
    }
}
