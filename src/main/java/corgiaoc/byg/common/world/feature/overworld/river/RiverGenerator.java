package corgiaoc.byg.common.world.feature.overworld.river;

import corgiaoc.byg.util.noise.fastnoise.FastNoise;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Used to dynamically create a randomly generated path from 1 object to another.
 */
public class RiverGenerator {
    private final FastNoise noise;
    private final List<Node> nodes;

    public RiverGenerator(FastNoise noise, BlockPos startPos, ChunkGenerator generator, Predicate<BlockPos> isInvalid, Predicate<BlockPos> isValid, int maxDistance) {
        this.noise = noise;
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node(startPos));
        int distanceInNodes = maxDistance / 5;

        int startY = startPos.getY();

        for (int i = 1; i < distanceInNodes; i++) {
            Node prevNode = nodes.get(i - 1);
            float angle = this.noise.GetNoise(startPos.getX(), i, startPos.getZ());

            Vector2f dAngle = get2DAngle(angle * 5, 5);
            BlockPos previousNodePos = prevNode.getPos();
            BlockPos addedPos = previousNodePos.add(new Vector3i(dAngle.x, 0, dAngle.y));
            int newY = generator.getNoiseHeight(addedPos.getX(), addedPos.getZ(), Heightmap.Type.OCEAN_FLOOR_WG);

            if (newY > previousNodePos.getY()) {
                newY = previousNodePos.getY();
            }

//            double slide = newY / ((float) startY - generator.getSeaLevel());
//            newY = (int) MathHelper.clampedLerp(generator.getSeaLevel(), startY, slide);

            Node nextNode = new Node(new BlockPos(addedPos.getX(), newY, addedPos.getZ()));

            if (isInvalid.test(nextNode.getPos())) {
                break;
            }

            if (isValid.test(nextNode.getPos())) {
                nodes.add(nextNode);
                this.nodes = nodes;
                return;

            }
            nodes.add(nextNode);
        }
        this.nodes = null;
    }

    public boolean exists() {
        return nodes != null;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public BlockPos getFinalPosition() {
        return this.nodes.get(this.nodes.size() - 1).getPos();
    }

    public static Vector2f get2DAngle(float angle, float length) {
        float x = (float) (Math.sin(angle) * length);
        float y = (float) (Math.cos(angle) * length);

        return new Vector2f(x, y);
    }


    static class Node {
        private BlockPos pos;

        private Node(BlockPos pos) {
            this.pos = pos;
        }

        public BlockPos getPos() {
            return pos;
        }

        public void upgradeY(int y) {
            this.pos = new BlockPos(pos.getX(), y, pos.getZ());
        }
    }
}
