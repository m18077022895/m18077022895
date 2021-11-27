package com.hgs;

import com.hgs.annotation.Car;
import com.hgs.annotation.MainConfig;
import com.hgs.annotation.Truck;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.LinkedList;
import java.util.concurrent.*;

public class Test {

	@org.junit.Test
	public void test1() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-test.xml");
		Student student = (Student)applicationContext.getBean("student");
		System.out.println(student.getUsername());
		System.out.println("我获取用户名了："+student.getUsername());
	}

	@org.junit.Test
	public void test2() throws ExecutionException, InterruptedException {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		Car car = applicationContext.getBean("car",Car.class);
		Truck truck = applicationContext.getBean("truck",Truck.class);
		truck.test();
		System.out.println(car.name);

		ThreadLocal<Object> threadLocal = new ThreadLocal<>();
		FutureTask<Integer> task = new FutureTask<>(new CallAbleTest());
		ConcurrentHashMap hashMap = new ConcurrentHashMap();
		//1.7 sgement 分段的形式 ， 内部其实是HashMap,超过阈值才去扩容

		//任务来的时候，1 先创建核心线程数量
		//			2 如果核心线程数满了，把任务放入阻塞队列
		//          3 队列也满了，然后判断是否达到了最大线程数，如果没有创建非核心线程数
		//			4 如果达到了最大线程数，则会启动拒绝策略
		//线程池大小的配置
		//	1 IO密集型 2N+1
		//	2 CPU 密集型 N+1
		//  3 混合型
		ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 2,
				60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), r -> null, new RejectedExecutionHandler() {
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				//1 任务谁提交，返回给谁处理
				//2 丢弃任务，并抛出异常
				//3 直接丢弃，什么也没有
				//4 丢弃线程池中最老的任务，然后放入最新的任务

			}
		});
		poolExecutor.allowCoreThreadTimeOut(true);
//		new Thread(task).start();
//		Integer temp = task.get();
//		System.out.printf("temp:"+temp);

//		LockSupport.unpark();
//		LockSupport.park();
//		applicationContext.scan("com.hgs")
//操作系统分配资源（cup ，内存等）的最小单位进程，操作系统（cup）调度任务的最小单位线程
		//因为AOP是在bean的实例化之后，如果代理对象有循环依赖的场景就没法解决，注入的是原始对象而不是代理对象的问题。
		applicationContext.close();
		LinkedList linkedList = new LinkedList();
		Iterable iterable = (Iterable) linkedList.iterator();

		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("eee");
	}

	class CallAbleTest implements Callable<Integer> {
		@Override
		public Integer call() throws Exception {
			return 1;
		}
	}
}
