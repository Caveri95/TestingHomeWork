import java.lang.reflect.Field;

public class  EmptyObjectCheck <T> {

    private T entity;
    private boolean empty;

    public EmptyObjectCheck() {
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public boolean isEmpty() throws IllegalAccessException {
        isEmptyObject();
        return empty;
    }

    private void isEmptyObject() throws IllegalAccessException {
        Field[] fields = User.class.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            if (field.get(this.entity) != null) {
                System.out.println("Объект заполнен!");
                this.empty = false;
                return;
            } else {

                this.empty = true;
            }
        }
    }
}