package blood4life.User.access;

import java.util.List;

import blood4life.commons.domain.Sangre;

public interface ISangreAcces {
    public Sangre findSangre(int sangreId);
    public List<Sangre> listaSangres();
}
