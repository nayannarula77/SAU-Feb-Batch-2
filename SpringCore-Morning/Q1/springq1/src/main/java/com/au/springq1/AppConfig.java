package com.au.springq1;

import java.util.Arrays;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(name="rectangleObj")
    public Rectangle getRectangle() {
        return new Rectangle(50,100);
    }
    @Bean(name="pointA")
    public Point getPointA() {
        return new Point(0,0);
    }
    @Bean(name="pointB")
    public Point getPointB() {
        return new Point(10,0);
    }
    @Bean(name="pointC")
    public Point getPointC() {
        return new Point(0,20);
    }
    @Bean(name="pointD")
    public Point getPointD() {
        return new Point(10,20);
    }
    @Bean(name="points")
    public List<Point> getPoints(){
    	return Arrays.asList(getPointA(), getPointB(), getPointC(), getPointD());
    }
}