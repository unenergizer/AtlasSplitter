# AtlasSplitter

AtlasSplitter will split atlas texture regions into multiple .png image files. Powered by [LibGDX](https://libgdx.badlogicgames.com/).

## AtlasSplitter Purpose

Often I would create an atlas of my game assets and then do mass Photoshop edits of all texture regions.

An example could be replacing a color or deleting colors from an atlas image. If you had a lot of images to edit, this could become tedious work. By packing the images using [LibGDX Texture Packer](https://github.com/libgdx/libgdx/wiki/Texture-packer) you could do mass edits and then separate the images. Thus potentially saving you a lot of time.

Why separate the images?
If you did do mass edits, you would have to redo them every time you add a new texture to your atlas. So making the mass edit once and then saving all the images will prevent you from having to do this every time you add textures to your atlas.

## Usage

In ```AtlasSplitterMain``` replace the follow text "test_atlas" with your atlas file name.
```java
private static final String FILE_NAME = "test_atlas";
```
The above becomes:
```java
private static final String FILE_NAME = "SomeNewAtlasName";
```

Do not append ```.atlas``` to the file name.

## Contributing
Pull requests are welcome.

## License
[APACHE LICENSE, VERSION 2.0](https://www.apache.org/licenses/LICENSE-2.0)