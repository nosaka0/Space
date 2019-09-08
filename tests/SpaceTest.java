import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpaceTest {

	@Test
	void addShapeShouldAddShape() {
		Space space = new Space("addShapeShouldAddShape", 500, 500);

		Shape s = new Shape(1,100,100,100,100);
		space.addShape(s);
		assertEquals(s, space.getShapes().get(0));

		space.addShape(1,100,100,100,100);
		assertEquals(2, space.getShapes().size());
	}

	@Test
	void multipleShapesShouldPopulateProperly() {
		Space space = new Space("multipleShapesShouldPopulateProperly", 500,500);

		for(int i = 0; i < 5; i++) {
			space.addShape(i % 4, 100, 100, 100, 100);
		}

		assertEquals(5, space.getShapes().size());

	}
}