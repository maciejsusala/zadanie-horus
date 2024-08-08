package pl.maciej.susala.zadaniehorus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WallTest {
    private Wall wall;

    @BeforeEach
    public void setUp() throws Exception {
        wall = new Wall();
        Block block1 = Mockito.mock(Block.class);
        Block block2 = Mockito.mock(Block.class);
        Block block3 = Mockito.mock(Block.class);
        Block block4 = Mockito.mock(Block.class);

        Mockito.when(block1.getColor()).thenReturn("red");
        Mockito.when(block1.getMaterial()).thenReturn("brick");
        Mockito.when(block2.getColor()).thenReturn("blue");
        Mockito.when(block2.getMaterial()).thenReturn("concrete");
        Mockito.when(block3.getColor()).thenReturn("red");
        Mockito.when(block3.getMaterial()).thenReturn("wood");
        Mockito.when(block4.getMaterial()).thenReturn("brick");
        Mockito.when(block4.getColor()).thenReturn("gray");

        List<Block> blocks = List.of(block1, block2, block3, block4);

        Field blocksField = Wall.class.getDeclaredField("blocks");
        blocksField.setAccessible(true);
        blocksField.set(wall, blocks);
    }



    @Test
    public void testFindBlockByColor() {
        Optional<Block> block = wall.findBlockByColor("blue");
        assertTrue(block.isPresent());
        assertEquals("concrete", block.get().getMaterial());
    }

    @Test
    public void testFindBlocksByMaterial() {
        List<Block> blocks = wall.findBlocksByMaterial("brick");
        assertEquals(2, blocks.size());
        assertEquals("red", blocks.get(0).getColor());
        assertEquals("gray", blocks.get(1).getColor());
    }

    @Test
    public void testCount() {
        assertEquals(4, wall.count());
    }
}