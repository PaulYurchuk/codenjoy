package com.codenjoy.dojo.snake.battle.model;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2016 Codenjoy
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */


import com.codenjoy.dojo.services.LengthToXY;
import com.codenjoy.dojo.services.Point;

import java.util.LinkedList;
import java.util.List;

import static com.codenjoy.dojo.snake.battle.model.Elements.*;
import static com.codenjoy.dojo.snake.battle.model.Elements.HEAD_DOWN;

/**
 * Полезный утилитный класс для получения объектов на поле из текстового вида.
 */
public class LevelImpl implements Level {
    private final LengthToXY xy;

    private String map;

    public LevelImpl(String map) {
        this.map = map;
        xy = new LengthToXY(getSize());
    }

    @Override
    public int getSize() {
        return (int) Math.sqrt(map.length());
    }

    @Override
    public List<Hero> getHero() {
        List<Hero> result = new LinkedList<>();
        addHeroesToList(result, HEAD_DOWN,
                HEAD_LEFT,
                HEAD_RIGHT,
                HEAD_UP,
                HEAD_DEAD);
        return result;
    }

    private void addHeroesToList(List<Hero> list, Elements... elements) {
        for (Elements element : elements)
            for (Point pt : getPointsOf(element))
                list.add(new Hero(pt));
    }

    @Override
    public List<Apple> getApples() {
        List<Apple> result = new LinkedList<>();
        for (Point pt : getPointsOf(APPLE))
            result.add(new Apple(pt));
        return result;
    }

    @Override
    public List<Stone> getStones() {
        List<Stone> result = new LinkedList<>();
        for (Point pt : getPointsOf(STONE))
            result.add(new Stone(pt));

        return result;
    }

    @Override
    public List<Wall> getWalls() {
        List<Wall> result = new LinkedList<>();
        for (Point pt : getPointsOf(WALL))
            result.add(new Wall(pt));
        return result;
    }

    private List<Point> getPointsOf(Elements element) {
        List<Point> result = new LinkedList<>();
        for (int index = 0; index < map.length(); index++) {
            if (map.charAt(index) == element.ch) {
                result.add(xy.getXY(index));
            }
        }
        return result;
    }
}
