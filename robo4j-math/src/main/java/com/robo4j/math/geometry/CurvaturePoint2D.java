/*
 * Copyright (C) 2017. Miroslav Wengner, Marcus Hirt
 * This CurvaturePoint2D.java  is part of robo4j.
 * module: robo4j-math
 *
 * robo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * robo4j is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with robo4j .  If not, see <http://www.gnu.org/licenses/>.
 */
package com.robo4j.math.geometry;

/**
 * A point used when establishing curvature in points. Used when doing feature
 * extraction, such as detecting corners.
 * 
 * @author Marcus Hirt
 */
public class CurvaturePoint2D extends Point2D {
	private final float curvature;

	public CurvaturePoint2D(float range, float angle, float curvature) {
		super(range, angle);
		this.curvature = curvature;
	}

	public CurvaturePoint2D(Point2D point, float totalPhi) {
		this(point.getRange(), point.getAngle(), totalPhi);
	}

	public float getCurvature() {
		return curvature;
	}
}
