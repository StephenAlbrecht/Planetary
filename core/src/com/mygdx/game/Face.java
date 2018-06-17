package com.mygdx.game;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.util.vmath;

public class Face{
    
    public Vector3[] pts = new Vector3[3];
    public Vector3 centroid;
    public Array<Face> nbrs = new Array<Face>();

    Face(Vector3 p0, Vector3 p1, Vector3 p2) {
        this.pts[0] = p0;
        this.pts[1] = p1;
        this.pts[2] = p2;
        this.centroid = getCentroid(p0, p1, p2).nor();
    }

    public void addNbr(Face face) {
        nbrs.add(face);
    }

    boolean testNeighbor(Face b) {
        if(nbrs.contains(b, false))
            return false;
        int count = 0;
        for(int i = 0; i < pts.length; i++) {
            for(int j = 0; j < b.pts.length; j++) {
                if (pts[i] == b.pts[j]) {
                    count++;
                }
            }
        }
        if(count == 2) {
            return true;
        } else
            return false;
    }

    Vector3 getCentroid(Vector3 p0, Vector3 p1, Vector3 p2) {
        return new Vector3(
                (p0.x + p1.x + p2.x)/3,
                (p0.y + p1.y + p2.y)/3,
                (p0.z + p1.z + p2.z)/3);
    }
}
