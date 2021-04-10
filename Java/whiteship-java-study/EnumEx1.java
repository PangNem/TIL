
public class EnumEx1 {
  public static void main(String[] args) {
    Unit unit = new Unit();
    unit.move(Unit.Direction.EAST);
    unit.move(Unit.Direction.EAST);
    unit.move(Unit.Direction.SOUTH);

    unit.printDirectionValues();
    unit.printValueOfDirection("EAST");
  }
}


class Unit {
  enum Direction { EAST, SOUTH, WEST, NORTH };

  int x, y;
  Direction[] directionArray = Direction.values();

  public Unit() {
    this.x = this.y = 0;
  }

  public void move (Direction direction) {
    switch (direction) {
      case EAST: x++;
        break;
      case WEST: x--;
        break;
      case SOUTH: y++;
        break;
      case NORTH: y--;
        break;
    }
  }

  public void printDirectionValues() {
    for (Direction direction : directionArray) {
      System.out.printf("%s=%d%n", direction.name(), direction.ordinal());
    }
  }

  public void printValueOfDirection(String name) {
    System.out.println(Direction.valueOf(name));
  }

}