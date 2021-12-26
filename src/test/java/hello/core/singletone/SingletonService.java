package hello.core.singletone;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    private SingletonService () {}

    public static SingletonService getInstance() {
        return instance;
    }

    @Test
    @DisplayName("같은 instance가 리턴되어야 한다")
    void isSameInstance () {
        SingletonService instance1 = getInstance();
        SingletonService instance2 = getInstance();

        Assertions.assertThat(instance1).isSameAs(instance2);
    }
}
