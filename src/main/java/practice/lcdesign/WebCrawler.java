//package practice.lcdesign;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//import java.util.concurrent.*;
//import java.util.concurrent.atomic.AtomicLong;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//import java.net.*;
//
//// 234. Web Crawler
//// Chapter 10
//public class WebCrawler {
//
//    ExecutorService pool = Executors.newFixedThreadPool(3);
//    AtomicLong tasks = new AtomicLong(0);
//    Lock lock = new ReentrantLock();
//    List<String> ans = new ArrayList<>();
//    Set<String> visited = new HashSet<>();
//
//    private class CrawlTask implements Runnable {
//        String url;
//
//        public CrawlTask(String u) {
//            url = u;
//        }
//
//        @Override
//        public void run() {
//            try {
//                for (String neighbor : HtmlHelper.parseUrls(url)) {
//                    URL neighborURL = new URL(neighbor);
//                    if (!neighborURL.getHost().endsWith("wikipedia.org")) continue;  // may throw exception
//                    lock.lock();
//                    if (!visited.contains(neighbor)) {  // found new URL to crawl
//                        visited.add(neighbor);
//                        ans.add(neighbor);
//                        pool.execute(new CrawlTask(neighbor));
//                        tasks.incrementAndGet();
//                    }
//                    lock.unlock();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                tasks.decrementAndGet();
//            }
//        }
//    }
//
//    public List<String> crawler(String url) {
//        visited.add(url);
//        ans.add(url);
//        pool.execute(new CrawlTask(url));
//        tasks.incrementAndGet();
//        try {
//            while (tasks.get() != 0) Thread.sleep(3000);
//            ;  // wait until no more tasks
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        pool.shutdown();  // otherwise program won't stop
//        return ans;
//    }
//}
