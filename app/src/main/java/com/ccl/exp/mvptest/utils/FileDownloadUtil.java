package com.ccl.exp.mvptest.utils;

import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadLargeFileListener;
import com.liulishuo.filedownloader.FileDownloader;

/**
 * Created by ccl on 2016/10/25.
 * filedownloader:library库封装
 */
public class FileDownloadUtil {

    private FileDownloader fileDownloader;

    public FileDownloadUtil() {
        this.fileDownloader = new FileDownloader();
    }

    /**
     * 下载文件
     *
     * @param url  URL地址
     * @param path 下载后存储路径
     */
    public void downLoadFile(String url, String path, final OnDownLoadListener listener) {
        fileDownloader.getImpl()
                .create(url)
                .setPath(path)
                .setAutoRetryTimes(1)//重试次数
                .setListener(new FileDownloadLargeFileListener() {
                    @Override
                    protected void pending(BaseDownloadTask task, long soFarBytes, long totalBytes) {

                    }

                    @Override
                    protected void started(BaseDownloadTask task) {
                        if (listener != null) {
                            listener.start();
                        }
                    }

                    @Override
                    protected void progress(BaseDownloadTask task, long soFarBytes, long totalBytes) {
                        if (listener != null) {
                            int progress = (int) ((double) soFarBytes / (double) totalBytes * 100);
                            listener.progress(progress);
                        }
                    }

                    @Override
                    protected void blockComplete(BaseDownloadTask task) {

                    }

                    @Override
                    protected void completed(BaseDownloadTask task) {
                        if (listener != null) {
                            listener.completed();
                        }
                    }

                    @Override
                    protected void paused(BaseDownloadTask task, long soFarBytes, long totalBytes) {

                    }

                    @Override
                    protected void error(BaseDownloadTask task, Throwable e) {
                        if (listener != null) {
                            listener.error(e);
                        }
                    }

                    @Override
                    protected void warn(BaseDownloadTask task) {

                    }


                }).start();
    }

    /**
     * 暂停下载
     */
    public void pause() {
        fileDownloader.pauseAll();
    }

    /**
     * 下载状态监听
     */
    public interface OnDownLoadListener {
        /**
         * 下载进度百分比
         *
         * @param progerss
         */
        void progress(int progerss);

        /**
         * 下载完成
         */
        void completed();

        /**
         * 下载错误
         *
         * @param e
         */
        void error(Throwable e);

        /**
         * 下载开始
         */
        void start();
    }
}
