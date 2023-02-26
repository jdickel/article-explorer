package me.jdickel.articleexplorer.entities;

import java.util.Objects;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.Transient;

@MappedSuperclass
public abstract class AbstractBaseEntity implements Persistable<UUID> {

	@Id
	@Column(name = "id", length = 16, unique = true, nullable = false)
	private UUID id = UUID.randomUUID();

	@Transient
	private boolean persisted = false;

	public UUID getId() {
		return id;
	}

	public boolean isNew() {
		return !persisted;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractBaseEntity other = (AbstractBaseEntity) obj;
		return Objects.equals(id, other.id);
	}

	@PostPersist
	@PostLoad
	private void setPersisted() {
		persisted = true;
	}
}
