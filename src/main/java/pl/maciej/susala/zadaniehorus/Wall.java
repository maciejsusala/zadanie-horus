package pl.maciej.susala.zadaniehorus;

import java.util.List;
import java.util.Optional;

interface Structure {
    // zwraca dowolny element o podanym kolorze
    Optional<Block> findBlockByColor(String color);

    // zwraca wszystkie elementy z danego materiału
    List<Block> findBlocksByMaterial(String material);

    //zwraca liczbę wszystkich elementów tworzących strukturę
    int count();
}

/**
 * The Wall class represents a structure composed of multiple blocks.
 * It provides methods to find blocks by color or material and to count the total number of blocks.
 */
public class Wall implements Structure {
    private List<Block> blocks;

    /**
     * Finds a block by its color.
     *
     * @param color the color of the block to find
     * @return an Optional containing a block with the specified color, or an empty Optional if no such block is found
     */
    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream()
                .filter(block -> block.getColor().equals(color))
                .findAny();
    }

    /**
     * Finds all blocks made of a specific material.
     *
     * @param material the material of the blocks to find
     * @return a list of blocks made of the specified material
     */
    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blocks.stream()
                .filter(block -> block.getMaterial().equals(material))
                .toList();
    }

    /**
     * Counts the total number of blocks in the wall.
     *
     * @return the total number of blocks
     */
    @Override
    public int count() {
        return blocks.size();
    }
}

interface Block {
    String getColor();
    String getMaterial();
}

interface CompositeBlock extends Block {
    List<Block> getBlocks();
}

