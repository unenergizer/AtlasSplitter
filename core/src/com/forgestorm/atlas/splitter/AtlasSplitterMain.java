package com.forgestorm.atlas.splitter;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AtlasSplitterMain extends ApplicationAdapter {

    // TODO: Edit your file name here!
    private static final String FILE_NAME = "test_atlas";

    @Override
    public void create() {

        // Load files
        AssetManager manager = new AssetManager();
        manager.load(Common.INPUT_DIR + FILE_NAME + Common.ATLAS, TextureAtlas.class);
        manager.update();
        manager.finishLoading();
        TextureAtlas spriteAtlas = manager.get(Common.INPUT_DIR + FILE_NAME + Common.ATLAS, TextureAtlas.class);

        FileHandle fileHandle = Gdx.files.internal(Common.INPUT_DIR + FILE_NAME + Common.PNG);
        Pixmap atlasTexture = new Pixmap(fileHandle);

        final int spritesTotal = spriteAtlas.getRegions().size;
        System.out.println("Atlas File: " + FILE_NAME + Common.ATLAS);
        System.out.println("Sprites Total: " + spritesTotal);

        // Process atlas regions
        for (int i = 0; i < spritesTotal; i++) {
            TextureAtlas.AtlasRegion atlasRegion = spriteAtlas.getRegions().get(i);
            Pixmap partTexture = new Pixmap(
                    atlasRegion.getRegionWidth(),
                    atlasRegion.getRegionHeight(),
                    Pixmap.Format.RGBA8888);
            partTexture.drawPixmap(
                    atlasTexture,
                    0,
                    0,
                    atlasRegion.getRegionX(),
                    atlasRegion.getRegionY(),
                    atlasRegion.getRegionWidth(),
                    atlasRegion.originalHeight);

            // Save images
            PixmapIO.writePNG(new FileHandle(Common.OUTPUT_DIR + atlasRegion.name + Common.PNG), partTexture);

            partTexture.dispose();
            System.out.println("[" + (i + 1) + "/" + spritesTotal + "] Processed: " + atlasRegion.name);
        }
        System.out.println("Job done! Sprites processed total: " + spritesTotal);

        atlasTexture.dispose();
        manager.dispose();
    }

    @Override
    public void render() {
        Gdx.app.exit();
    }

    @Override
    public void dispose() {
    }

    private class Common {
        private static final String INPUT_DIR = "input/";
        private static final String OUTPUT_DIR = "output/";
        private static final String PNG = ".png";
        private static final String ATLAS = ".atlas";
    }
}
