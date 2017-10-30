package com.jack.springboot13batch.batch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * create by jack 2017/10/28
 * 监听器实现JobExecutionListener接口，并重写其beforeJob，afterJob方法即可
 */
public class CsvJobListener implements JobExecutionListener {
    private long startTime;
    private long endTime;
    @Override
    public void beforeJob(JobExecution jobExecution) {
        startTime = System.currentTimeMillis();
        System.out.println("任务处理开始");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        endTime = System.currentTimeMillis();
        System.out.println("任务处理结束");
        System.out.println("耗时："+(endTime-startTime)+"ms");
    }
}
