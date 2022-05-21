package potionstudios.byg.util.codec;

import org.jetbrains.annotations.Nullable;

public interface CommentsTracker {

    void addComment(String key, String comment);

    @Nullable
    String getComment(String key);
}
