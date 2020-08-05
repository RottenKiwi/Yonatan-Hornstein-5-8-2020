    package threadResource;
     
     
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.core.task.TaskExecutor;
    import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
     
    import java.util.concurrent.Executor;
     
    @Configuration
    public class ThreadConfig {
        @Bean
        public  ThreadPoolTaskExecutor taskExecutor() {
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setCorePoolSize(5);
            executor.setMaxPoolSize(10);
            executor.setThreadNamePrefix("default_task_executor_thread");
            executor.initialize();
            return executor;
        }
    }