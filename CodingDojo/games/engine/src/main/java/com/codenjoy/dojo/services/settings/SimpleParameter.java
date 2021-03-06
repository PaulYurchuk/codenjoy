package com.codenjoy.dojo.services.settings;

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


public class SimpleParameter<T> implements Parameter<T> {

    private T value;

    public SimpleParameter(T value) {
        this.value = value;
    }

    public static Parameter<Integer> v(int value) {
        return new SimpleParameter<Integer>(value);
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Object value) {
        this.value = (T)value;
    }

    @Override
    public Parameter def(Object value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean itsMe(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void select(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Parameter type(Class integerClass) {
        throw new UnsupportedOperationException();
    }
}
