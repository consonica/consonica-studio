/*
 * Created on Feb 14, 2006
 *
 * Copyright (c) 2006 P.J.Leonard
 * 
 * http://www.frinika.com
 * 
 * This file is part of Frinika.
 * 
 * Frinika is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.

 * Frinika is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with Frinika; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package com.frinika.util.math;

public class MyMath {

    static public double halfLifeToLambda(double halfLifeInTicks) {
        // N=halfLifeInTicks
        // decay^N = 0.5
        // N ln(decay)= ln(0.5)
        // decay = e^(ln(0.5)/N)

        return Math.exp(Math.log(0.5) / halfLifeInTicks);
    }
}
